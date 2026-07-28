package exercicios25072026parte1.contabil.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;
import exercicios25072026parte1.contabil.enums.TipoMovimento;
import exercicios25072026parte1.contabil.model.ItemLancamento;
import exercicios25072026parte1.contabil.model.LancamentoContabil;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.LancamentoRepository;
import exercicios25072026parte1.contabil.service.LancamentoContabilService;
import exercicios25072026parte1.contabil.service.LivroDiarioService;


public class LivroDiarioTest {


    public static void main(String[] args) {


        LancamentoRepository repository =
                new LancamentoRepository();



        LancamentoContabilService lancamentoService =
                new LancamentoContabilService(repository);



        LivroDiarioService livro =
                new LivroDiarioService(lancamentoService);



        PlanoConta caixa =
                new PlanoConta(
                        1,
                        "1.1.01",
                        "Caixa",
                        NaturezaConta.ATIVO,
                        TipoConta.ANALITICA,
                        3,
                        true
                );



        PlanoConta banco =
                new PlanoConta(
                        2,
                        "1.1.02",
                        "Banco",
                        NaturezaConta.ATIVO,
                        TipoConta.ANALITICA,
                        3,
                        true
                );



        LancamentoContabil lancamento =
                new LancamentoContabil(
                        1,
                        LocalDate.now(),
                        "NF001",
                        "Depósito inicial"
                );



        ItemLancamento debito =
                new ItemLancamento(
                        1,
                        caixa,
                        null,
                        TipoMovimento.DEBITO,
                        new BigDecimal("1000.00")
                );



        ItemLancamento credito =
                new ItemLancamento(
                        2,
                        banco,
                        null,
                        TipoMovimento.CREDITO,
                        new BigDecimal("1000.00")
                );



        lancamento.adicionarItem(debito);

        lancamento.adicionarItem(credito);



        lancamentoService.salvar(lancamento);



        livro.gerar()
                .forEach(System.out::println);


    }

}