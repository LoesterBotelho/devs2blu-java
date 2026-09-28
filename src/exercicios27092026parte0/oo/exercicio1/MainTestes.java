package exercicios27092026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

        Cliente joao = new Cliente(
                1L,
                "João",
                "Blumenau"
        );

        Cliente maria = new Cliente(
                2L,
                "Maria",
                "Joinville"
        );

        Cliente carlos = new Cliente(
                3L,
                "Carlos",
                "Blumenau"
        );

        Produto notebook = new Produto(
                1L,
                "Notebook",
                "Eletrônicos",
                new BigDecimal("4500.00")
        );

        Produto mouse = new Produto(
                2L,
                "Mouse",
                "Periféricos",
                new BigDecimal("150.00")
        );

        Produto teclado = new Produto(
                3L,
                "Teclado",
                "Periféricos",
                new BigDecimal("300.00")
        );

        Produto monitor = new Produto(
                4L,
                "Monitor",
                "Eletrônicos",
                new BigDecimal("1800.00")
        );

        Pedido pedido1 = new Pedido(
                1L,
                joao,
                List.of(
                        new ItemPedido(notebook, 1),
                        new ItemPedido(mouse, 2)
                ),
                StatusPedido.APROVADO
        );

        Pedido pedido2 = new Pedido(
                2L,
                maria,
                List.of(
                        new ItemPedido(teclado, 1),
                        new ItemPedido(monitor, 2)
                ),
                StatusPedido.APROVADO
        );

        Pedido pedido3 = new Pedido(
                3L,
                carlos,
                List.of(
                        new ItemPedido(mouse, 3)
                ),
                StatusPedido.PENDENTE
        );

        Pedido pedido4 = new Pedido(
                4L,
                joao,
                List.of(
                        new ItemPedido(monitor, 1)
                ),
                StatusPedido.CANCELADO
        );

        List<Pedido> pedidos = List.of(
                pedido1,
                pedido2,
                pedido3,
                pedido4
        );

        System.out.println("PEDIDOS");

        AnalisadorPedidos.processar(
                pedidos,
                System.out::println
        );

        System.out.println("\nAPROVADOS");

        AnalisadorPedidos.filtrar(
                pedidos,
                pedido ->
                        pedido.getStatus() == StatusPedido.APROVADO
        ).forEach(System.out::println);

        System.out.println("\nFATURAMENTO");

        BigDecimal faturamento =
                AnalisadorPedidos.calcularFaturamento(
                        pedidos,
                        pedido ->
                                pedido.getStatus() ==
                                        StatusPedido.APROVADO
                );

        System.out.println(faturamento);

        System.out.println("\nFATURAMENTO POR CIDADE");

        System.out.println(
                AnalisadorPedidos.faturamentoPorCidade(pedidos)
        );

        System.out.println("\nPEDIDOS POR CIDADE");

        System.out.println(
                AnalisadorPedidos.quantidadePedidosPorCidade(
                        pedidos
                )
        );

        System.out.println("\nPOR STATUS");

        System.out.println(
                AnalisadorPedidos.agruparPorStatus(
                        pedidos
                )
        );

        System.out.println("\nPRODUTO MAIS CARO");

        System.out.println(
                AnalisadorPedidos.produtoMaisCaro(
                        pedidos
                )
        );

        System.out.println("\nORDENADOS");

        AnalisadorPedidos.ordenarPorValor(
                pedidos
        ).forEach(System.out::println);

        System.out.println("\nCLIENTES");

        List<String> clientes =
                AnalisadorPedidos.transformar(
                        pedidos,
                        pedido ->
                                pedido.getCliente().getNome()
                );

        clientes.forEach(System.out::println);
    }
}