package exercicios26092026parte0.oo.exercicio4;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MainTestes {

    public static void main(String[] args) {

        Pedido p1 = new Pedido(
                "P001",
                "Loester",
                StatusPedido.APROVADO,
                List.of(
                        new ItemPedido(
                                "Notebook Gamer",
                                "Eletrônicos",
                                new BigDecimal("4500.00"),
                                1
                        ),
                        new ItemPedido(
                                "Mousepad",
                                "Acessórios",
                                new BigDecimal("80.00"),
                                2
                        )
                )
        );

        Pedido p2 = new Pedido(
                "P002",
                "Beatriz",
                StatusPedido.APROVADO,
                List.of(
                        new ItemPedido(
                                "Monitor Ultrawide",
                                "Eletrônicos",
                                new BigDecimal("1800.00"),
                                1
                        ),
                        new ItemPedido(
                                "Teclado Mecânico",
                                "Eletrônicos",
                                new BigDecimal("350.00"),
                                1
                        )
                )
        );

        Pedido p3 = new Pedido(
                "P003",
                "Leticia",
                StatusPedido.CANCELADO,
                List.of(
                        new ItemPedido(
                                "Cadeira de Escritório",
                                "Móveis",
                                new BigDecimal("950.00"),
                                1
                        )
                )
        );

        Pedido p4 = new Pedido(
                "P004",
                "Rute",
                StatusPedido.PENDENTE,
                List.of(
                        new ItemPedido(
                                "Headset",
                                "Acessórios",
                                new BigDecimal("500.00"),
                                1
                        ),
                        new ItemPedido(
                                "Webcam",
                                "Acessórios",
                                new BigDecimal("700.00"),
                                1
                        )
                )
        );

        List<Pedido> pedidos = List.of(
                p1,
                p2,
                p3,
                p4
        );

        System.out.println(
                "---------------------------------------------------------------------------------------------------"
        );

        System.out.println(
                "RELATÓRIO DE PEDIDOS"
        );

        System.out.println(
                "---------------------------------------------------------------------------------------------------"
        );

        BigDecimal faturamentoAprovado =
                AnalisadorPedidos.calcularFaturamentoFiltrado(
                        pedidos,
                        pedido ->
                                pedido.getStatus()
                                        == StatusPedido.APROVADO
                );

        System.out.printf(
                "Faturamento aprovado: R$ %.2f%n",
                faturamentoAprovado
        );

        System.out.println();

        Map<String, BigDecimal> porCategoria =
                AnalisadorPedidos
                        .faturamentoPorCategoriaAprovados(
                                pedidos
                        );

        System.out.println(
                "Faturamento por categoria:"
        );

        porCategoria.forEach(
                (categoria, valor) ->
                        System.out.printf(
                                "  %s: R$ %.2f%n",
                                categoria,
                                valor
                        )
        );

        System.out.println();

        ItemPedido produtoMaisCaro =
                AnalisadorPedidos.produtoMaisCaro(
                        pedidos
                );

        System.out.println(
                "Produto mais caro:"
        );

        System.out.println(
                "  " + produtoMaisCaro
        );

        System.out.println();

        System.out.println(
                "Pedidos ordenados por valor:"
        );

        List<Pedido> pedidosOrdenados =
                AnalisadorPedidos
                        .ordenarPorValorDescendente(
                                pedidos
                        );

        pedidosOrdenados.forEach(
                pedido ->
                        System.out.printf(
                                "  %s - R$ %.2f%n",
                                pedido.getIdPedido(),
                                pedido.getValorTotalPedido()
                        )
        );

        System.out.println();

        System.out.println(
                "Clientes:"
        );

        List<String> clientes =
                AnalisadorPedidos.transformar(
                        pedidos,
                        Pedido::getCliente
                );

        clientes.forEach(
                cliente ->
                        System.out.println(
                                "  " + cliente
                        )
        );

        System.out.println();

        System.out.println(
                "Processamento genérico:"
        );

        AnalisadorPedidos.processarEImprimir(
                pedidos,
                pedido ->
                        System.out.println(
                                "  " + pedido
                        )
        );

        System.out.println();

        BigDecimal totalGeral =
                AnalisadorPedidos.calcularTotal(
                        pedidos
                );

        System.out.printf(
                "Total geral: R$ %.2f%n",
                totalGeral
        );
    }
}