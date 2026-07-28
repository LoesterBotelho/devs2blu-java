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







    /**
     * Cadastra uma conta no plano de contas
     */
    public void cadastrar(
            PlanoConta conta) {


        validar(conta);


        repository.salvar(conta);

    }








    /**
     * Cadastro em lote
     */
    public void cadastrarTodos(
            List<PlanoConta> contas) {


        if(contas == null || contas.isEmpty()) {

            return;

        }



        contas.forEach(
                this::cadastrar
        );


    }









    /**
     * Busca por ID
     */
    public Optional<PlanoConta> buscar(
            Integer id) {


        return repository.buscar(id);

    }








    /**
     * Busca pelo código contábil
     */
    public Optional<PlanoConta> buscarPorCodigo(
            String codigo) {



        if(codigo == null || codigo.isBlank()) {

            return Optional.empty();

        }



        return repository.listar()

                .stream()

                .filter(

                        conta ->

                        codigo.equalsIgnoreCase(
                                conta.getCodigo()
                        )

                )

                .findFirst();

    }








    /**
     * Lista todas ordenadas
     */
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








    /**
     * Lista somente contas analíticas
     */
    public List<PlanoConta> listarAnaliticas() {


        return repository.listar()

                .stream()

                .filter(
                        PlanoConta::isAnalitica
                )

                .sorted(
                        Comparator.naturalOrder()
                )

                .toList();


    }









    /**
     * Lista somente contas sintéticas
     */
    public List<PlanoConta> listarSinteticas() {


        return repository.listar()

                .stream()

                .filter(
                        PlanoConta::isSintetica
                )

                .sorted(
                        Comparator.naturalOrder()
                )

                .toList();


    }









    /**
     * Lista contas raiz
     */
    public List<PlanoConta> listarRaizes() {


        return repository.listar()

                .stream()

                .filter(

                        conta ->

                        conta.getContaPai() == null

                )

                .sorted(
                        Comparator.naturalOrder()
                )

                .toList();


    }









    /**
     * Adiciona uma conta filha
     */
    public void adicionarFilha(

            Integer idPai,

            PlanoConta filha) {



        PlanoConta pai =

                buscar(idPai)

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




        pai.adicionarFilha(
                filha
        );



        repository.salvar(
                filha
        );


    }









    /**
     * Remove conta
     */
    public void remover(
            Integer id) {



        PlanoConta conta =

                buscar(id)

                .orElseThrow(

                        () ->

                        new RuntimeException(

                                "Conta não encontrada: "
                                + id

                        )

                );





        if(conta.possuiFilhos()) {


            throw new RuntimeException(

                    "Não é permitido remover conta com filhos"

            );

        }





        if(conta.getContaPai() != null) {


            conta.getContaPai()

                    .removerFilha(conta);

        }





        repository.removerPorId(id);


    }









    /**
     * Ativa conta
     */
    public void ativar(
            Integer id) {


        PlanoConta conta = buscar(id)

                .orElseThrow(

                        () ->

                        new RuntimeException(
                                "Conta não encontrada"
                        )

                );


        conta.setAtivo(true);


    }









    /**
     * Desativa conta
     */
    public void desativar(
            Integer id) {



        PlanoConta conta = buscar(id)

                .orElseThrow(

                        () ->

                        new RuntimeException(
                                "Conta não encontrada"
                        )

                );





        if(conta.possuiFilhos()) {


            throw new RuntimeException(

                    "Conta com filhos não pode ser desativada"

            );

        }





        conta.setAtivo(false);


    }









    /**
     * Localização recursiva na árvore
     */
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









    /**
     * Saldo total incluindo filhos
     */
    public BigDecimal saldoTotal(
            Integer id) {



        PlanoConta conta =

                buscar(id)

                .orElseThrow(

                        () ->

                        new RuntimeException(

                                "Conta não encontrada: "
                                + id

                        )

                );



        return conta.calcularSaldoTotal();


    }









    /**
     * Quantidade de contas cadastradas
     */
    public long quantidade() {


        return repository.quantidade();

    }









    /**
     * Validação da conta
     */
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

                    "Código já cadastrado: "
                    + conta.getCodigo()

            );

        }





        if(conta.isAnalitica()
                &&
           !conta.isAceitaLancamento()) {



            throw new RuntimeException(

                    "Conta analítica deve aceitar lançamento"

            );

        }




        if(conta.isSintetica()
                &&
           conta.isAceitaLancamento()) {



            throw new RuntimeException(

                    "Conta sintética não pode aceitar lançamento"

            );

        }


    }









    /**
     * Imprime árvore completa
     */
    public void imprimirArvore() {


        List<PlanoConta> raizes =
                listarRaizes();




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
                "          PLANO DE CONTAS"
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