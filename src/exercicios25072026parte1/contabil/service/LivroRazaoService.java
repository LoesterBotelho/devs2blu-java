package exercicios25072026parte1.contabil.service;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import exercicios25072026parte1.contabil.enums.StatusLancamento;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.relatorio.LivroRazaoRelatorio;



public class LivroRazaoService {


    private final LancamentoContabilService lancamentoService;




    public LivroRazaoService(
            LancamentoContabilService lancamentoService) {


        this.lancamentoService =
                lancamentoService;

    }









    /**
     * Agrupa movimentos por conta.
     */
    public Map<PlanoConta, List<ItemLancamento>> agruparPorConta() {


        return lancamentoService.listar()

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

    }









    /**
     * Gera razão de uma conta específica.
     */
    public List<LivroRazaoRelatorio> gerar(
            PlanoConta conta) {


        Objects.requireNonNull(
                conta,
                "Conta obrigatória"
        );



        List<MovimentoConta> movimentos =


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

                                .filter(

                                        item ->

                                        item.getConta()
                                                .equals(conta)

                                )

                                .map(

                                        item ->

                                        new MovimentoConta(

                                                lancamento,

                                                item

                                        )

                                )

                )

                .sorted(

                        Comparator.comparing(

                                m ->

                                m.lancamento()
                                        .getData()

                        )

                )

                .toList();





        BigDecimal saldo =
                BigDecimal.ZERO;



        List<LivroRazaoRelatorio> resultado =
                new java.util.ArrayList<>();





        for(MovimentoConta movimento :
                movimentos) {


            ItemLancamento item =
                    movimento.item();



            BigDecimal debito =
                    BigDecimal.ZERO;



            BigDecimal credito =
                    BigDecimal.ZERO;




            if(item.isDebito()) {


                debito =
                        item.getValor();


                saldo =
                        saldo.add(
                                debito
                        );


            } else {


                credito =
                        item.getValor();


                saldo =
                        saldo.subtract(
                                credito
                        );

            }





            LancamentoContabil lancamento =
                    movimento.lancamento();





            resultado.add(

                    new LivroRazaoRelatorio(

                            lancamento.getData(),

                            lancamento.getDocumento(),

                            lancamento.getHistorico(),

                            item.getMovimento(),

                            debito,

                            credito,

                            saldo

                    )

            );

        }



        return resultado;

    }









    /**
     * Saldo atual da conta.
     */
    public BigDecimal saldo(
            PlanoConta conta) {


        List<LivroRazaoRelatorio> relatorio =
                gerar(conta);



        if(relatorio.isEmpty()) {

            return BigDecimal.ZERO;

        }



        return relatorio

                .get(relatorio.size() - 1)

                .getSaldo();

    }









    /**
     * Classe auxiliar interna.
     */
    private record MovimentoConta(

            LancamentoContabil lancamento,

            ItemLancamento item

    ) {}



}