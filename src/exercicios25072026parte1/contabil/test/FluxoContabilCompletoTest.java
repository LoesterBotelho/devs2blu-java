package exercicios25072026parte1.contabil.test;


import java.math.BigDecimal;
import java.time.LocalDate;


import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.enums.TipoMovimento;
import exercicios25072026parte1.contabil.service.BalanceteService;
import exercicios25072026parte1.contabil.service.LancamentoContabilService;
import exercicios25072026parte1.contabil.service.LivroDiarioService;
import exercicios25072026parte1.contabil.service.LivroRazaoService;



public class FluxoContabilCompletoTest {


    public static void main(String[] args) {


        System.out.println(
                "================================="
        );

        System.out.println(
                "   TESTE FLUXO CONTÁBIL COMPLETO"
        );

        System.out.println(
                "================================="
        );



        /*
         * Contexto ERP
         */

        ContabilContext context =
                new ContabilContext();



        LancamentoContabilService lancamentoService =
                context.getLancamentoService();



        LivroDiarioService livroDiario =
                context.getLivroDiarioService();



        LivroRazaoService livroRazao =
                context.getLivroRazaoService();



        BalanceteService balancete =
                context.getBalanceteService();





        /*
         * Buscar contas
         */

        PlanoConta caixa =

                context.getPlanoContaService()

                .buscarPorCodigo("1.1.01")

                .orElseThrow();



        PlanoConta capitalSocial =

                context.getPlanoContaService()

                .buscarPorCodigo("3.1.01")

                .orElseThrow();






        /*
         * Criar lançamento
         */

        LancamentoContabil lancamento =

                new LancamentoContabil();



        lancamento.setData(
                LocalDate.now()
        );


        lancamento.setDocumento(
                "NF001"
        );


        lancamento.setHistorico(
                "Integralização de capital"
        );





        /*
         * Débito
         */

        ItemLancamento debito =

                new ItemLancamento(

                        caixa,

                        TipoMovimento.DEBITO,

                        new BigDecimal("10000.00")

                );





        /*
         * Crédito
         */

        ItemLancamento credito =

                new ItemLancamento(

                        capitalSocial,

                        TipoMovimento.CREDITO,

                        new BigDecimal("10000.00")

                );





        lancamento.adicionarItem(
                debito
        );


        lancamento.adicionarItem(
                credito
        );






        /*
         * Salvar
         */

        lancamentoService.salvar(
                lancamento
        );



        Integer id =

                lancamento.getId();



        System.out.println();

        System.out.println(
                "ID Lançamento: "
                + id
        );






        /*
         * Validar
         */

        lancamentoService.validar(
                id
        );


        System.out.println(
                "VALIDAÇÃO: OK"
        );






        /*
         * Postar
         */

        lancamentoService.postar(
                id
        );


        System.out.println(
                "POSTAGEM: OK"
        );






        /*
         * Livro Diário
         */

        System.out.println();

        System.out.println(
                "=============="
        );

        System.out.println(
                " LIVRO DIÁRIO"
        );

        System.out.println(
                "=============="
        );


        livroDiario.gerar()

                .forEach(System.out::println);








        /*
         * Livro Razão
         */

        System.out.println();

        System.out.println(
                "=============="
        );

        System.out.println(
                " LIVRO RAZÃO"
        );

        System.out.println(
                "=============="
        );



        livroRazao.gerar(caixa)

                .forEach(System.out::println);








        /*
         * Balancete
         */

        System.out.println();

        System.out.println(
                "=============="
        );

        System.out.println(
                " BALANCETE"
        );

        System.out.println(
                "=============="
        );



        balancete.gerar()

                .forEach(System.out::println);




        System.out.println();

        System.out.println(
                "Débito = Crédito ? "
                +
                balancete.partidaDobradaOk()
        );



        System.out.println();

        System.out.println(
                "================================="
        );

        System.out.println(
                " TESTE FINALIZADO"
        );

        System.out.println(
                "================================="
        );


    }


}