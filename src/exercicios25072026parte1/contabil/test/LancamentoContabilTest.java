package exercicios25072026parte1.contabil.test;


import java.math.BigDecimal;
import java.time.LocalDate;

import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.enums.TipoMovimento;
import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;



public class LancamentoContabilTest {


    public static void main(String[] args) {


        ContabilContext context =
                new ContabilContext();



        PlanoConta caixa =

                context.getPlanoContaService()

                        .buscarPorCodigo("1.1.01")

                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Conta Caixa não encontrada"
                                )
                        );




        PlanoConta capital =

                context.getPlanoContaService()

                        .buscarPorCodigo("3.1.01")

                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Conta Capital não encontrada"
                                )
                        );





        CentroCusto administrativo =

                context.getCentroCustoService()

                        .buscarPorCodigo("10")

                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Centro Administrativo não encontrado"
                                )
                        );





        LancamentoContabil lancamento =

                new LancamentoContabil();



        lancamento.setData(
                LocalDate.now()
        );


        lancamento.setDocumento(
                "CAP001"
        );


        lancamento.setHistorico(
                "Integralização de capital"
        );





        lancamento.adicionarItem(

                new ItemLancamento(

                        null,

                        caixa,

                        administrativo,

                        TipoMovimento.DEBITO,

                        BigDecimal.valueOf(10000)

                )

        );





        lancamento.adicionarItem(

                new ItemLancamento(

                        null,

                        capital,

                        administrativo,

                        TipoMovimento.CREDITO,

                        BigDecimal.valueOf(10000)

                )

        );






        context.getLancamentoService()

                .salvar(lancamento);





        System.out.println(
                "================================"
        );

        System.out.println(
                " Lançamento Contábil"
        );

        System.out.println(
                "================================"
        );



        System.out.println(
                lancamento
        );



        System.out.println(
                "Débito total: R$ "
                        + lancamento.totalDebito()
        );



        System.out.println(
                "Crédito total: R$ "
                        + lancamento.totalCredito()
        );



        System.out.println(
                "Partida dobrada válida: "
                        + lancamento.partidaDobradaValida()
        );



    }

}