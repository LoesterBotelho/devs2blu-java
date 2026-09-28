package exercicios27092026parte0.oo.exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

        List<Transacao> transacoes = List.of(

                new Transacao(
                        1L,
                        "João",
                        TipoTransacao.VENDA,
                        StatusTransacao.PROCESSADA,
                        new BigDecimal("1500.00")
                ),

                new Transacao(
                        2L,
                        "Maria",
                        TipoTransacao.VENDA,
                        StatusTransacao.PROCESSADA,
                        new BigDecimal("3200.00")
                ),

                new Transacao(
                        3L,
                        "João",
                        TipoTransacao.PAGAMENTO,
                        StatusTransacao.PROCESSADA,
                        new BigDecimal("800.00")
                ),

                new Transacao(
                        4L,
                        "Carlos",
                        TipoTransacao.ESTORNO,
                        StatusTransacao.PROCESSADA,
                        new BigDecimal("500.00")
                ),

                new Transacao(
                        5L,
                        "Maria",
                        TipoTransacao.TRANSFERENCIA,
                        StatusTransacao.PENDENTE,
                        new BigDecimal("7000.00")
                ),

                new Transacao(
                        6L,
                        "Carlos",
                        TipoTransacao.VENDA,
                        StatusTransacao.CANCELADA,
                        new BigDecimal("900.00")
                ),

                new Transacao(
                        7L,
                        "Ana",
                        TipoTransacao.VENDA,
                        StatusTransacao.PROCESSADA,
                        new BigDecimal("5200.00")
                ),

                new Transacao(
                        8L,
                        "João",
                        TipoTransacao.TRANSFERENCIA,
                        StatusTransacao.PROCESSADA,
                        new BigDecimal("2500.00")
                ),

                new Transacao(
                        9L,
                        "Ana",
                        TipoTransacao.PAGAMENTO,
                        StatusTransacao.PENDENTE,
                        new BigDecimal("1800.00")
                ),

                new Transacao(
                        10L,
                        "Carlos",
                        TipoTransacao.VENDA,
                        StatusTransacao.PROCESSADA,
                        new BigDecimal("4200.00")
                )
        );

        System.out.println("TODAS AS TRANSAÇÕES");

        RelatorioFinanceiro.processar(
                transacoes,
                System.out::println
        );

        System.out.println("\nTOTAL PROCESSADO");

        BigDecimal totalProcessado =
                RelatorioFinanceiro.somar(
                        transacoes,
                        transacao ->
                                transacao.getStatus() ==
                                        StatusTransacao.PROCESSADA
                );

        System.out.println(
                "R$ " + totalProcessado
        );

        System.out.println("\nTOTAL DAS VENDAS");

        BigDecimal totalVendas =
                RelatorioFinanceiro.somar(
                        transacoes,
                        transacao ->
                                transacao.getTipo() ==
                                        TipoTransacao.VENDA
                );

        System.out.println(
                "R$ " + totalVendas
        );

        System.out.println("\nTOTAL POR TIPO");

        RelatorioFinanceiro.totalPorTipo(
                transacoes
        ).forEach(
                (tipo, total) ->
                        System.out.println(
                                tipo + " = R$ " + total
                        )
        );

        System.out.println("\nTOTAL POR CLIENTE");

        RelatorioFinanceiro.totalPorCliente(
                transacoes
        ).forEach(
                (cliente, total) ->
                        System.out.println(
                                cliente + " = R$ " + total
                        )
        );

        System.out.println("\nQUANTIDADE POR STATUS");

        RelatorioFinanceiro.quantidadePorStatus(
                transacoes
        ).forEach(
                (status, quantidade) ->
                        System.out.println(
                                status + " = " + quantidade
                        )
        );

        System.out.println("\nTRANSAÇÕES ACIMA DE R$ 2.000");

        RelatorioFinanceiro.particionarPorValor(
                transacoes,
                new BigDecimal("2000.00")
        ).get(true)
                .forEach(System.out::println);

        System.out.println("\nMAIOR TRANSAÇÃO");

        RelatorioFinanceiro.maiorTransacao(
                transacoes
        ).ifPresent(
                System.out::println
        );

        System.out.println("\nMENOR TRANSAÇÃO");

        RelatorioFinanceiro.menorTransacao(
                transacoes
        ).ifPresent(
                System.out::println
        );

        System.out.println("\nORDENADAS POR VALOR");

        RelatorioFinanceiro.ordenarPorValorDescendente(
                transacoes
        ).forEach(System.out::println);

        System.out.println("\nCLIENTES");

        RelatorioFinanceiro.extrairClientes(
                transacoes
        ).forEach(System.out::println);

        System.out.println("\nVENDAS PROCESSADAS");

        RelatorioFinanceiro.filtrar(
                transacoes,
                transacao ->
                        transacao.getTipo() ==
                                TipoTransacao.VENDA
                                &&
                                transacao.getStatus() ==
                                        StatusTransacao.PROCESSADA
        ).forEach(System.out::println);

        System.out.println("\nTRANSFORMAÇÃO");

        List<String> nomes =
                RelatorioFinanceiro.transformar(
                        transacoes,
                        Transacao::getCliente
                );

        nomes.forEach(System.out::println);

        System.out.println("\nCOPIANDO TRANSAÇÕES");

        List<Transacao> copia =
                new ArrayList<>();

        RelatorioFinanceiro.copiar(
                transacoes,
                copia
        );

        System.out.println(
                "Quantidade copiada: " + copia.size()
        );
    }
}