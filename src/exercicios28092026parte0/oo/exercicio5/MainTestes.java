package exercicios28092026parte0.oo.exercicio5;

import java.math.BigDecimal;
import java.util.Comparator;
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

        Cliente ana = new Cliente(
                4L,
                "Ana",
                "Florianópolis"
        );

        Cliente lucas = new Cliente(
                5L,
                "Lucas",
                "Itajaí"
        );

        Produto notebook = new Produto(
                1L,
                "Notebook",
                "Informática",
                new BigDecimal("4500.00")
        );

        Produto monitor = new Produto(
                2L,
                "Monitor",
                "Informática",
                new BigDecimal("1800.00")
        );

        Produto teclado = new Produto(
                3L,
                "Teclado",
                "Periféricos",
                new BigDecimal("350.00")
        );

        Produto mouse = new Produto(
                4L,
                "Mouse",
                "Periféricos",
                new BigDecimal("180.00")
        );

        Produto cadeira = new Produto(
                5L,
                "Cadeira Gamer",
                "Móveis",
                new BigDecimal("1500.00")
        );

        Produto headset = new Produto(
                6L,
                "Headset",
                "Periféricos",
                new BigDecimal("600.00")
        );

        List<Pedido> pedidos = List.of(

                new Pedido(
                        1L,
                        joao,
                        List.of(
                                new ItemPedido(notebook, 1),
                                new ItemPedido(mouse, 2)
                        ),
                        StatusPedido.APROVADO
                ),

                new Pedido(
                        2L,
                        maria,
                        List.of(
                                new ItemPedido(monitor, 2),
                                new ItemPedido(teclado, 1)
                        ),
                        StatusPedido.ENTREGUE
                ),

                new Pedido(
                        3L,
                        carlos,
                        List.of(
                                new ItemPedido(cadeira, 1),
                                new ItemPedido(headset, 1)
                        ),
                        StatusPedido.APROVADO
                ),

                new Pedido(
                        4L,
                        ana,
                        List.of(
                                new ItemPedido(notebook, 2)
                        ),
                        StatusPedido.ENVIADO
                ),

                new Pedido(
                        5L,
                        lucas,
                        List.of(
                                new ItemPedido(mouse, 3),
                                new ItemPedido(teclado, 2)
                        ),
                        StatusPedido.PENDENTE
                ),

                new Pedido(
                        6L,
                        joao,
                        List.of(
                                new ItemPedido(monitor, 1),
                                new ItemPedido(headset, 2)
                        ),
                        StatusPedido.ENTREGUE
                ),

                new Pedido(
                        7L,
                        maria,
                        List.of(
                                new ItemPedido(notebook, 1),
                                new ItemPedido(cadeira, 1)
                        ),
                        StatusPedido.APROVADO
                ),

                new Pedido(
                        8L,
                        carlos,
                        List.of(
                                new ItemPedido(teclado, 3),
                                new ItemPedido(mouse, 1)
                        ),
                        StatusPedido.CANCELADO
                ),

                new Pedido(
                        9L,
                        ana,
                        List.of(
                                new ItemPedido(monitor, 2),
                                new ItemPedido(headset, 1)
                        ),
                        StatusPedido.APROVADO
                ),

                new Pedido(
                        10L,
                        lucas,
                        List.of(
                                new ItemPedido(cadeira, 2)
                        ),
                        StatusPedido.ENTREGUE
                )
        );

        Pipeline<Pedido> pipeline = Pipeline.criar(pedidos);

        System.out.println("TODOS OS PEDIDOS");

        pipeline.listar()
                .forEach(System.out::println);

        System.out.println("\nPEDIDOS APROVADOS");

        pipeline
                .filtrar(pedido -> pedido.getStatus() == StatusPedido.APROVADO)
                .listar()
                .forEach(System.out::println);

        System.out.println("\nPEDIDOS ACIMA DE R$ 3.000");

        pipeline
                .filtrar(pedido ->
                        pedido.getValorTotal()
                                .compareTo(new BigDecimal("3000.00")) > 0)
                .listar()
                .forEach(System.out::println);

        System.out.println("\nPEDIDOS ORDENADOS POR VALOR");

        pipeline
                .ordenar(
                        Comparator.comparing(
                                Pedido::getValorTotal
                        ).reversed()
                )
                .listar()
                .forEach(System.out::println);

        System.out.println("\nTOP 3 PEDIDOS");

        pipeline
                .ordenar(
                        Comparator.comparing(
                                Pedido::getValorTotal
                        ).reversed()
                )
                .limitar(3)
                .listar()
                .forEach(System.out::println);

        System.out.println("\nNOMES DOS CLIENTES");

        pipeline
                .mapear(pedido -> pedido.getCliente().getNome())
                .listar()
                .forEach(System.out::println);

        System.out.println("\nCLIENTES DISTINTOS");

        pipeline
                .mapear(Pedido::getCliente)
                .distinct()
                .listar()
                .forEach(System.out::println);

        System.out.println("\nPRODUTOS DOS PEDIDOS");

        pipeline
                .flatMapear(Pedido::getItens)
                .mapear(ItemPedido::getProduto)
                .distinct()
                .listar()
                .forEach(System.out::println);

        System.out.println("\nNOMES DOS PRODUTOS");

        pipeline
                .flatMapear(Pedido::getItens)
                .mapear(ItemPedido::getProduto)
                .distinct()
                .mapear(Produto::getNome)
                .listar()
                .forEach(System.out::println);

        System.out.println("\nCATEGORIAS DOS PRODUTOS");

        pipeline
                .flatMapear(Pedido::getItens)
                .mapear(ItemPedido::getProduto)
                .mapear(Produto::getCategoria)
                .distinct()
                .listar()
                .forEach(System.out::println);

        System.out.println("\nTOTAL DE FATURAMENTO");

        BigDecimal faturamento = pipeline
                .filtrar(pedido ->
                        pedido.getStatus() != StatusPedido.CANCELADO)
                .somar(Pedido::getValorTotal);

        System.out.println(faturamento);

        System.out.println("\nTOTAL APROVADO");

        BigDecimal totalAprovado = pipeline
                .filtrar(pedido ->
                        pedido.getStatus() == StatusPedido.APROVADO)
                .somar(Pedido::getValorTotal);

        System.out.println(totalAprovado);

        System.out.println("\nMAIOR PEDIDO");

        pipeline
                .maior(
                        Comparator.comparing(
                                Pedido::getValorTotal
                        )
                )
                .ifPresent(System.out::println);

        System.out.println("\nMENOR PEDIDO");

        pipeline
                .menor(
                        Comparator.comparing(
                                Pedido::getValorTotal
                        )
                )
                .ifPresent(System.out::println);

        System.out.println("\nPRIMEIRO PEDIDO");

        pipeline
                .primeiro()
                .ifPresent(System.out::println);

        System.out.println("\nQUANTIDADE DE PEDIDOS");

        System.out.println(
                pipeline.contar()
        );

        System.out.println("\nPEDIDOS POR STATUS");

        pipeline
                .agruparPor(Pedido::getStatus)
                .forEach((status, lista) ->
                        System.out.println(
                                status + " = " + lista.size()
                        )
                );

        System.out.println("\nPEDIDOS POR CIDADE");

        pipeline
                .agruparPor(
                        pedido -> pedido.getCliente().getCidade()
                )
                .forEach((cidade, lista) ->
                        System.out.println(
                                cidade + " = " + lista.size()
                        )
                );

        System.out.println("\nPEDIDOS PULANDO OS 2 PRIMEIROS");

        pipeline
                .ordenar(
                        Comparator.comparing(
                                Pedido::getValorTotal
                        ).reversed()
                )
                .pular(2)
                .listar()
                .forEach(System.out::println);

        System.out.println("\nPEDIDOS APROVADOS, ORDENADOS E TOP 5");

        pipeline
                .filtrar(pedido ->
                        pedido.getStatus() == StatusPedido.APROVADO)
                .ordenar(
                        Comparator.comparing(
                                Pedido::getValorTotal
                        ).reversed()
                )
                .limitar(5)
                .listar()
                .forEach(System.out::println);

        System.out.println("\nCONSUMER");

        pipeline
                .filtrar(pedido ->
                        pedido.getStatus() == StatusPedido.APROVADO)
                .consumir(pedido ->
                        System.out.println(
                                "Pedido " +
                                pedido.getId() +
                                " - " +
                                pedido.getCliente().getNome()
                        )
                );
    }
}