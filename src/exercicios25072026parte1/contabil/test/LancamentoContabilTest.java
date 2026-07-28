package exercicios25072026parte1.contabil.test;


import java.math.BigDecimal;
import java.time.LocalDate;


import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.enums.TipoMovimento;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;



public class LancamentoContabilTest {


    public static void main(String[] args) {



        ContabilContext context =

                new ContabilContext();





        PlanoConta caixa =

                context.getPlanoContaService()

                        .localizarPorCodigo("1.1.01")

                        .orElseThrow(

                                () ->

                                new RuntimeException(
                                        "Conta Caixa não encontrada"
                                )

                        );






        PlanoConta capital =

                context.getPlanoContaService()

                        .localizarPorCodigo("3.1.01")

                        .orElseThrow(

                                () ->

                                new RuntimeException(
                                        "Conta Capital não encontrada"
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

                        caixa,

                        TipoMovimento.DEBITO,

                        BigDecimal.valueOf(10000)

                )

        );








        lancamento.adicionarItem(

                new ItemLancamento(

                        capital,

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





        System.out.println();





        System.out.println(

                "Saldo Caixa: R$ "

                + caixa.getSaldo()

        );





        System.out.println(

                "Saldo Capital: R$ "

                + capital.getSaldo()

        );



    }


}