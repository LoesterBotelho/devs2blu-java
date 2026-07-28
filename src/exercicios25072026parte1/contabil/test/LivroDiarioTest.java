package exercicios25072026parte1.contabil.test;


import java.math.BigDecimal;
import java.time.LocalDate;


import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.enums.TipoMovimento;
import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.service.LancamentoContabilService;
import exercicios25072026parte1.contabil.service.LivroDiarioService;



public class LivroDiarioTest {


    public static void main(String[] args) {


        ContabilContext context =
                new ContabilContext();




        LancamentoContabilService lancamentoService =

                context.getLancamentoService();




        LivroDiarioService livroDiarioService =

                context.getLivroDiarioService();






        PlanoConta caixa =

                context.getPlanoContaService()

                        .buscarPorCodigo("1.1.01")

                        .orElseThrow(() ->

                                new RuntimeException(
                                        "Conta Caixa não encontrada"
                                )
                        );






        PlanoConta banco =

                context.getPlanoContaService()

                        .buscarPorCodigo("1.1.02")

                        .orElseThrow(() ->

                                new RuntimeException(
                                        "Conta Banco não encontrada"
                                )
                        );






        CentroCusto administrativo =

                context.getCentroCustoService()

                        .buscarPorCodigo("10")

                        .orElseThrow(() ->

                                new RuntimeException(
                                        "Centro de custo Administrativo não encontrado"
                                )
                        );








        LancamentoContabil lancamento =

                new LancamentoContabil();







        lancamento.setData(

                LocalDate.now()

        );





        lancamento.setDocumento(

                "NF001"

        );





        lancamento.setHistorico(

                "Depósito inicial em banco"

        );








        /*
         * D - Banco
         * C - Caixa
         *
         * Transferência entre contas do Ativo
         */


        lancamento.adicionarItem(

                new ItemLancamento(

                        null,

                        banco,

                        administrativo,

                        TipoMovimento.DEBITO,

                        BigDecimal.valueOf(1000)

                )

        );







        lancamento.adicionarItem(

                new ItemLancamento(

                        null,

                        caixa,

                        administrativo,

                        TipoMovimento.CREDITO,

                        BigDecimal.valueOf(1000)

                )

        );








        lancamentoService.salvar(

                lancamento

        );





        lancamentoService.validar(

                lancamento.getId()

        );





        lancamentoService.postar(

                lancamento.getId()

        );








        System.out.println(
                "================================="
        );


        System.out.println(
                "         LIVRO DIÁRIO"
        );


        System.out.println(
                "================================="
        );







        livroDiarioService

                .gerar()

                .forEach(

                        System.out::println

                );

    }

}