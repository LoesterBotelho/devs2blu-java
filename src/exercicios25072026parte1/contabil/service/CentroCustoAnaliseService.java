package exercicios25072026parte1.contabil.service;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.relatorio.CentroCustoRelatorio;


public class CentroCustoAnaliseService {


    private final LancamentoContabilService lancamentoService;



    public CentroCustoAnaliseService(
            LancamentoContabilService lancamentoService) {

        this.lancamentoService = lancamentoService;

    }






    /**
     * Agrupa lançamentos por centro de custo
     */
    public Map<CentroCusto, List<ItemLancamento>> agrupar() {


        return lancamentoService.listarPostados()

                .stream()

                .flatMap(

                        lancamento ->

                        lancamento.getItens()
                                .stream()

                )

                .filter(

                        item -> item.getCentroCusto() != null

                )

                .collect(

                        Collectors.groupingBy(

                                ItemLancamento::getCentroCusto

                        )

                );

    }








    /**
     * Total gasto por centro de custo
     */
    public BigDecimal totalPorCentro(
            CentroCusto centroCusto) {


        return agrupar()

                .getOrDefault(
                        centroCusto,
                        List.of()
                )

                .stream()

                .filter(

                        ItemLancamento::isDebito

                )

                .map(

                        ItemLancamento::getValor

                )

                .reduce(

                        BigDecimal.ZERO,
                        BigDecimal::add

                );

    }








    /**
     * Lista todos os centros utilizados
     */
    public List<CentroCusto> centrosUtilizados() {


        return agrupar()

                .keySet()

                .stream()

                .toList();

    }


    public List<CentroCustoRelatorio> gerar() {


        return agrupar()

                .entrySet()

                .stream()

                .map(entry -> {


                    CentroCusto centro =
                            entry.getKey();



                    BigDecimal total =

                            entry.getValue()

                            .stream()

                            .filter(
                                    ItemLancamento::isDebito
                            )

                            .map(
                                    ItemLancamento::getValor
                            )

                            .reduce(

                                    BigDecimal.ZERO,

                                    BigDecimal::add

                            );



                    return new CentroCustoRelatorio(

                            centro,

                            total

                    );


                })

                .sorted(

                        Comparator.comparing(

                                rel ->

                                rel.getCentroCusto()
                                        .getCodigo()

                        )

                )

                .toList();


    }
    

}