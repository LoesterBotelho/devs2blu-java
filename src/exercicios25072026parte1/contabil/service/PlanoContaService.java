package exercicios25072026parte1.contabil.service;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;



public class PlanoContaService {


    private final PlanoContaRepository repository;



    public PlanoContaService(
            PlanoContaRepository repository) {

        this.repository = repository;

    }






    public void cadastrar(
            PlanoConta conta) {


        validar(conta);


        repository.salvar(conta);

    }







    public void cadastrarTodos(
            List<PlanoConta> contas) {


        if(contas == null || contas.isEmpty()) {

            return;

        }


        contas.forEach(
                this::cadastrar
        );

    }







    public Optional<PlanoConta> buscar(
            Integer id) {


        return repository.buscar(id);

    }








    public Optional<PlanoConta> buscarPorCodigo(
            String codigo) {


        return repository.listar()

                .stream()

                .filter(

                        conta ->

                        conta.getCodigo() != null

                        &&

                        conta.getCodigo()
                                .equalsIgnoreCase(codigo)

                )

                .findFirst();

    }







    public List<PlanoConta> listar() {


        return repository.listarOrdenado(


                Comparator.comparing(

                        PlanoConta::getCodigo,

                        Comparator.nullsLast(
                                String::compareToIgnoreCase
                        )

                )

        );

    }







    public void remover(
            Integer id) {


        repository.removerPorId(id);

    }







    public void adicionarFilha(
            Integer idPai,
            PlanoConta filha) {



        PlanoConta pai =


                repository.buscar(idPai)

                .orElseThrow(


                        () ->

                        new RuntimeException(

                                "Conta pai não encontrada: "

                                + idPai

                        )


                );




        if(pai.isAnalitica()) {


            throw new RuntimeException(

                    "Conta analítica não pode possuir contas filhas"

            );

        }





        validar(filha);



        pai.adicionarFilha(filha);



        repository.salvar(filha);


    }







    public Optional<PlanoConta> localizarPorCodigo(
            String codigo) {



        return repository.listar()

                .stream()

                .map(

                        conta ->

                        conta.localizarRecursivo(codigo)

                )

                .filter(

                        conta -> conta != null

                )

                .findFirst();

    }







    public BigDecimal saldoTotal(
            Integer id) {



        PlanoConta conta =


                repository.buscar(id)

                .orElseThrow(


                        () ->

                        new RuntimeException(

                                "Conta não encontrada: "

                                + id

                        )


                );



        return conta.calcularSaldoTotal();

    }








    private void validar(
            PlanoConta conta) {



        if(conta == null) {


            throw new RuntimeException(

                    "Plano de conta obrigatório"

            );

        }







        if(conta.getCodigo() == null

                ||

           conta.getCodigo().isBlank()) {



            throw new RuntimeException(

                    "Código da conta obrigatório"

            );

        }







        if(conta.getDescricao() == null

                ||

           conta.getDescricao().isBlank()) {



            throw new RuntimeException(

                    "Descrição obrigatória"

            );

        }







        boolean existe =


                repository.existe(



                        c ->


                        c.getCodigo() != null

                        &&

                        c.getCodigo()
                                .equalsIgnoreCase(
                                        conta.getCodigo()
                                )

                        &&

                        !c.equals(conta)



                );







        if(existe) {


            throw new RuntimeException(


                    "Código de conta já cadastrado: "

                    + conta.getCodigo()


            );

        }


    }








    /**
     * Imprime árvore completa do plano de contas
     */
    public void imprimirArvore() {



        List<PlanoConta> raizes =


                repository.listar()

                .stream()

                .filter(

                        conta ->

                        conta.getContaPai() == null

                )

                .sorted(

                        Comparator.comparing(

                                PlanoConta::getCodigo,

                                Comparator.nullsLast(

                                        String::compareToIgnoreCase

                                )

                        )

                )

                .toList();







        if(raizes.isEmpty()) {


            System.out.println(

                    "Nenhuma conta cadastrada"

            );


            return;

        }







        System.out.println(
                "================================="
        );


        System.out.println(
                "      PLANO DE CONTAS"
        );


        System.out.println(
                "================================="
        );







        raizes.forEach(

                conta ->

                conta.imprimir("")

        );

    }



}