package exercicios25072026parte1.contabil.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.enums.TipoMovimento;
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
                        .localizarPorCodigo("1.1.01")
                        .orElseThrow(() ->
                                new RuntimeException("Conta Caixa não encontrada"));

        PlanoConta banco =
                context.getPlanoContaService()
                        .localizarPorCodigo("1.1.02")
                        .orElseThrow(() ->
                                new RuntimeException("Conta Banco não encontrada"));

        LancamentoContabil lancamento =
                new LancamentoContabil();

        lancamento.setData(LocalDate.now());
        lancamento.setDocumento("NF001");
        lancamento.setHistorico("Depósito inicial");

        lancamento.adicionarItem(

                new ItemLancamento(

                        caixa,
                        TipoMovimento.DEBITO,
                        BigDecimal.valueOf(1000)

                )

        );

        lancamento.adicionarItem(

                new ItemLancamento(

                        banco,
                        TipoMovimento.CREDITO,
                        BigDecimal.valueOf(1000)

                )

        );

        lancamentoService.salvar(lancamento);

        System.out.println("=================================");
        System.out.println("         LIVRO DIÁRIO");
        System.out.println("=================================");

        livroDiarioService
                .gerar()
                .forEach(System.out::println);

    }

}