package exercicios25072026parte1.contabil.service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.repository.CentroCustoRepository;



public class CentroCustoService {


    private final CentroCustoRepository repository;




    public CentroCustoService(
            CentroCustoRepository repository) {

        this.repository = repository;

    }







    public void cadastrar(
            CentroCusto centroCusto) {


        validar(centroCusto);


        repository.salvar(centroCusto);

    }







    public Optional<CentroCusto> buscar(
            Integer id) {


        return repository.buscar(id);

    }







    public List<CentroCusto> listar() {


        return repository.listarOrdenado(

                Comparator.comparing(

                        CentroCusto::getCodigo,

                        Comparator.nullsLast(
                                String::compareToIgnoreCase
                        )

                )

        );

    }







    public Optional<CentroCusto> buscarPorCodigo(
            String codigo) {


        return repository.listar()

                .stream()

                .filter(

                        centro ->

                        centro.getCodigo()
                                .equalsIgnoreCase(codigo)

                )

                .findFirst();

    }







    public void remover(
            Integer id) {


        repository.removerPorId(id);

    }







    public long quantidade() {


        return repository.quantidade();

    }







    private void validar(
            CentroCusto centroCusto) {



        if(centroCusto == null) {


            throw new RuntimeException(

                    "Centro de custo obrigatório"

            );

        }







        if(centroCusto.getCodigo() == null
                ||
           centroCusto.getCodigo().isBlank()) {


            throw new RuntimeException(

                    "Código do centro de custo obrigatório"

            );

        }







        if(centroCusto.getDescricao() == null
                ||
           centroCusto.getDescricao().isBlank()) {


            throw new RuntimeException(

                    "Descrição do centro de custo obrigatória"

            );

        }







        boolean existe =

                repository.existe(

                        c ->


                        c.getCodigo()
                                .equalsIgnoreCase(
                                        centroCusto.getCodigo()
                                )

                        &&

                        !c.equals(centroCusto)

                );







        if(existe) {


            throw new RuntimeException(

                    "Centro de custo já cadastrado: "
                    + centroCusto.getCodigo()

            );

        }


    }


}