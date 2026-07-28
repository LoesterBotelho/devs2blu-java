package exercicios25072026parte1.contabil.service;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import exercicios25072026parte1.contabil.enums.StatusLancamento;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.relatorio.BalanceteRelatorio;



public class BalanceteService {


    private final LancamentoContabilService lancamentoService;




    public BalanceteService(
            LancamentoContabilService lancamentoService) {

        this.lancamentoService =
                lancamentoService;

    }








    /**
     * Gera balancete somente com lançamentos postados.
     */
    public List<BalanceteRelatorio> gerar() {


        Map<PlanoConta, List<ItemLancamento>> agrupado =


                lancamentoService.listar()

                        .stream()

                        .filter(

                                lancamento ->

                                lancamento.getStatus()

                                        ==

                                StatusLancamento.POSTADO

                        )

                        .flatMap(

                                lancamento ->

                                lancamento.getItens()
                                        .stream()

                        )

                        .collect(

                                Collectors.groupingBy(

                                        ItemLancamento::getConta

                                )

                        );





        return agrupado.entrySet()

                .stream()

                .map(entry -> {


                    PlanoConta conta =
                            entry.getKey();



                    BigDecimal debito =


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





                    BigDecimal credito =


                            entry.getValue()

                                    .stream()

                                    .filter(
                                            ItemLancamento::isCredito
                                    )

                                    .map(
                                            ItemLancamento::getValor
                                    )

                                    .reduce(

                                            BigDecimal.ZERO,

                                            BigDecimal::add

                                    );





                    BigDecimal saldo =

                            debito.subtract(
                                    credito
                            );





                    return new BalanceteRelatorio(

                            conta,

                            debito,

                            credito,

                            saldo

                    );


                })

                .sorted(

                        Comparator.comparing(

                                rel ->

                                rel.getConta()
                                        .getCodigo()

                        )

                )

                .toList();


    }









    public BigDecimal totalDebito() {


        return gerar()

                .stream()

                .map(

                        BalanceteRelatorio::getTotalDebito

                )

                .reduce(

                        BigDecimal.ZERO,

                        BigDecimal::add

                );

    }









    public BigDecimal totalCredito() {


        return gerar()

                .stream()

                .map(

                        BalanceteRelatorio::getTotalCredito

                )

                .reduce(

                        BigDecimal.ZERO,

                        BigDecimal::add

                );

    }









    /**
     * Regra fundamental:
     *
     * Débito = Crédito
     */
    public boolean partidaDobradaOk() {


        return totalDebito()

                .compareTo(

                        totalCredito()

                )

                == 0;

    }









    /**
     * Alias mais amigável.
     */
    public boolean estaBalanceado() {


        return partidaDobradaOk();

    }


}