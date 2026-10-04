package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

        Cliente joao =
                new Cliente(
                        1L,
                        "Joao"
                );

        Cliente maria =
                new Cliente(
                        2L,
                        "Maria"
                );

        Conta contaJoao =
                new Conta(
                        1001L,
                        joao,
                        TipoConta.CORRENTE,
                        new BigDecimal("5000")
                );

        Conta contaMaria =
                new Conta(
                        1002L,
                        maria,
                        TipoConta.INVESTIMENTO,
                        new BigDecimal("15000")
                );

        Transacao t1 =
                new Transacao(
                        1L,
                        contaJoao,
                        TipoTransacao.DEPOSITO,
                        new BigDecimal("3000"),
                        LocalDateTime.now(),
                        StatusTransacao.APROVADA
                );

        Transacao t2 =
                new Transacao(
                        2L,
                        contaJoao,
                        TipoTransacao.SAQUE,
                        new BigDecimal("1000"),
                        LocalDateTime.now(),
                        StatusTransacao.APROVADA
                );

        Transacao t3 =
                new Transacao(
                        3L,
                        contaMaria,
                        TipoTransacao.DEPOSITO,
                        new BigDecimal("20000"),
                        LocalDateTime.now(),
                        StatusTransacao.APROVADA
                );

        Transacao t4 =
                new Transacao(
                        4L,
                        contaMaria,
                        TipoTransacao.TRANSFERENCIA,
                        new BigDecimal("5000"),
                        LocalDateTime.now(),
                        StatusTransacao.APROVADA
                );

        List<Transacao> transacoes =
                List.of(
                        t1,
                        t2,
                        t3,
                        t4
                );

        TransacaoAnalyzer analyzer =
                new TransacaoAnalyzer();

        System.out.println(
                analyzer.totalPorTipo(transacoes)
        );

        System.out.println(
                analyzer.totalPorCliente(transacoes)
        );

        RiskAnalyzer risk =
                new RiskAnalyzer();

        System.out.println(
                risk.suspeitas(transacoes)
        );

        RankingService ranking =
                new RankingService();

        System.out.println(
                ranking.ranking(transacoes)
        );

        EstatisticaService estatistica =
                new EstatisticaService();

        System.out.println(
                estatistica.total(transacoes)
        );

        System.out.println(
                estatistica.media(transacoes)
        );

        System.out.println(
                estatistica.maior(transacoes)
        );

        BancoService banco =
                new BancoService(
                        new SaldoCalculator()
                );

        System.out.println(
                banco.saldo(
                        contaJoao,
                        transacoes
                )
        );

        RelatorioService relatorio =
                new RelatorioService();

        relatorio.imprimir(transacoes);
    }
}