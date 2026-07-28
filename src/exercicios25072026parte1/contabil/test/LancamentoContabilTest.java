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

                        .buscarPorCodigo("1.1.01")

                        .orElseThrow();





        PlanoConta capital =

                context.getPlanoContaService()

                        .buscarPorCodigo("3.1.01")

                        .orElseThrow();






        LancamentoContabil lancamento =

                new LancamentoContabil();






        lancamento.setData(
                LocalDate.now()
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
                "Lançamento salvo"
        );





        System.out.println(
                "Caixa: "
                +
                caixa.getSaldo()
        );





        System.out.println(
                "Capital: "
                +
                capital.getSaldo()
        );





        System.out.println(
                "Débitos: "
                +
                lancamento.totalDebito()
        );





        System.out.println(
                "Créditos: "
                +
                lancamento.totalCredito()
        );





        System.out.println(
                "Partida dobrada válida: "
                +
                lancamento.partidaDobradaValida()
        );


    }


}