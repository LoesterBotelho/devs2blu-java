package exercicios28092026parte0.oo.exercicio3;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MainExercicio3 {

    public static void main(String[] args) {

        List<Pagamento> pagamentos = List.of(

                new Pagamento(
                        1L,
                        "Joao",
                        TipoPagamento.PIX,
                        StatusPagamento.APROVADO,
                        new BigDecimal("1500.00")
                ),

                new Pagamento(
                        2L,
                        "Maria",
                        TipoPagamento.CARTAO,
                        StatusPagamento.APROVADO,
                        new BigDecimal("3200.00")
                ),

                new Pagamento(
                        3L,
                        "Carlos",
                        TipoPagamento.BOLETO,
                        StatusPagamento.PROCESSANDO,
                        new BigDecimal("850.00")
                ),

                new Pagamento(
                        4L,
                        "Ana",
                        TipoPagamento.PIX,
                        StatusPagamento.APROVADO,
                        new BigDecimal("5200.00")
                ),

                new Pagamento(
                        5L,
                        "Pedro",
                        TipoPagamento.TRANSFERENCIA,
                        StatusPagamento.RECUSADO,
                        new BigDecimal("7400.00")
                ),

                new Pagamento(
                        6L,
                        "Fernanda",
                        TipoPagamento.CARTAO,
                        StatusPagamento.APROVADO,
                        new BigDecimal("6800.00")
                ),

                new Pagamento(
                        7L,
                        "Lucas",
                        TipoPagamento.PIX,
                        StatusPagamento.CANCELADO,
                        new BigDecimal("950.00")
                ),

                new Pagamento(
                        8L,
                        "Juliana",
                        TipoPagamento.BOLETO,
                        StatusPagamento.APROVADO,
                        new BigDecimal("2100.00")
                ),

                new Pagamento(
                        9L,
                        "Rafael",
                        TipoPagamento.TRANSFERENCIA,
                        StatusPagamento.APROVADO,
                        new BigDecimal("12500.00")
                ),

                new Pagamento(
                        10L,
                        "Camila",
                        TipoPagamento.CARTAO,
                        StatusPagamento.PROCESSANDO,
                        new BigDecimal("4300.00")
                ),

                new Pagamento(
                        11L,
                        "Joao",
                        TipoPagamento.PIX,
                        StatusPagamento.APROVADO,
                        new BigDecimal("2700.00")
                ),

                new Pagamento(
                        12L,
                        "Maria",
                        TipoPagamento.CARTAO,
                        StatusPagamento.RECUSADO,
                        new BigDecimal("11000.00")
                ),

                new Pagamento(
                        13L,
                        "Carlos",
                        TipoPagamento.BOLETO,
                        StatusPagamento.APROVADO,
                        new BigDecimal("1750.00")
                ),

                new Pagamento(
                        14L,
                        "Ana",
                        TipoPagamento.PIX,
                        StatusPagamento.PROCESSANDO,
                        new BigDecimal("3900.00")
                ),

                new Pagamento(
                        15L,
                        "Rafael",
                        TipoPagamento.TRANSFERENCIA,
                        StatusPagamento.APROVADO,
                        new BigDecimal("8700.00")
                )
        );

        System.out.println("TODOS OS PAGAMENTOS");

        pagamentos.forEach(
                System.out::println
        );

        System.out.println("\nPAGAMENTOS APROVADOS");

        List<Pagamento> aprovados =
                ProcessadorPagamentos.filtrar(
                        pagamentos,
                        pagamento ->
                                pagamento.getStatus()
                                        == StatusPagamento.APROVADO
                );

        aprovados.forEach(
                System.out::println
        );

        System.out.println("\nPAGAMENTOS PIX");

        List<Pagamento> pix =
                ProcessadorPagamentos.filtrar(
                        pagamentos,
                        pagamento ->
                                pagamento.getTipo()
                                        == TipoPagamento.PIX
                );

        pix.forEach(
                System.out::println
        );

        System.out.println("\nVALORES");

        List<BigDecimal> valores =
                ProcessadorPagamentos.transformar(
                        pagamentos,
                        Pagamento::getValor
                );

        valores.forEach(
                System.out::println
        );

        System.out.println("\nCLIENTES");

        List<String> clientes =
                ProcessadorPagamentos.transformar(
                        pagamentos,
                        Pagamento::getCliente
                );

        clientes.forEach(
                System.out::println
        );

        System.out.println("\nMAIOR PAGAMENTO");

        ProcessadorPagamentos.maior(
                        pagamentos,
                        java.util.Comparator.comparing(
                                Pagamento::getValor
                        )
                )
                .ifPresent(
                        System.out::println
                );

        System.out.println("\nMENOR PAGAMENTO");

        ProcessadorPagamentos.menor(
                        pagamentos,
                        java.util.Comparator.comparing(
                                Pagamento::getValor
                        )
                )
                .ifPresent(
                        System.out::println
                );

        System.out.println("\nTOTAL DOS PAGAMENTOS");

        BigDecimal total =
                ProcessadorPagamentos.somar(
                        pagamentos,
                        Pagamento::getValor
                );

        System.out.println(total);

        System.out.println("\nTOTAL APROVADO");

        BigDecimal totalAprovado =
                ProcessadorPagamentos.somar(
                        aprovados,
                        Pagamento::getValor
                );

        System.out.println(totalAprovado);

        System.out.println("\nAGRUPADOS POR TIPO");

        Map<TipoPagamento, List<Pagamento>> porTipo =
                ProcessadorPagamentos.agruparPorTipo(
                        pagamentos
                );

        porTipo.forEach(
                (tipo, lista) ->
                        System.out.println(
                                tipo +
                                " -> " +
                                lista.size()
                        )
        );

        System.out.println("\nAGRUPADOS POR STATUS");

        Map<StatusPagamento, List<Pagamento>> porStatus =
                ProcessadorPagamentos.agruparPorStatus(
                        pagamentos
                );

        porStatus.forEach(
                (status, lista) ->
                        System.out.println(
                                status +
                                " -> " +
                                lista.size()
                        )
        );

        System.out.println("\nPARTICIONADOS POR R$ 5.000");

        Map<Boolean, List<Pagamento>> particionados =
                ProcessadorPagamentos.particionarPorValor(
                        pagamentos,
                        new BigDecimal("5000.00")
                );

        System.out.println("\nAcima de R$ 5.000:");

        particionados
                .get(true)
                .forEach(
                        System.out::println
                );

        System.out.println("\nAté R$ 5.000:");

        particionados
                .get(false)
                .forEach(
                        System.out::println
                );

        System.out.println("\nREGRA DE TAXA PIX");

        RegraPagamento<Pagamento> taxaPix =
                pagamento ->
                        pagamento.getValor()
                                .multiply(
                                        new BigDecimal("0.01")
                                );

        BigDecimal taxaPrimeiroPix =
                ProcessadorPagamentos.aplicarRegra(
                        pix.getFirst(),
                        taxaPix
                );

        System.out.println(
                "Taxa: " + taxaPrimeiroPix
        );

        System.out.println("\nTAXAS DE TODOS OS PIX");

        List<BigDecimal> taxasPix =
                ProcessadorPagamentos.aplicarRegra(
                        pix,
                        taxaPix
                );

        taxasPix.forEach(
                System.out::println
        );

        System.out.println("\nREGRA DE TAXA CARTAO");

        RegraPagamento<Pagamento> taxaCartao =
                pagamento ->
                        pagamento.getValor()
                                .multiply(
                                        new BigDecimal("0.03")
                                );

        List<Pagamento> cartoes =
                ProcessadorPagamentos.filtrar(
                        pagamentos,
                        pagamento ->
                                pagamento.getTipo()
                                        == TipoPagamento.CARTAO
                );

        List<BigDecimal> taxasCartao =
                ProcessadorPagamentos.aplicarRegra(
                        cartoes,
                        taxaCartao
                );

        taxasCartao.forEach(
                System.out::println
        );
    }
}