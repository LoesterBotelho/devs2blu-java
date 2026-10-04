package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

        Cliente joao =
                new Cliente(
                        1L,
                        "Joao",
                        TipoCliente.VIP
                );

        Cliente maria =
                new Cliente(
                        2L,
                        "Maria",
                        TipoCliente.PREMIUM
                );

        Produto notebook =
                new Produto(
                        1L,
                        "Notebook",
                        Categoria.INFORMATICA,
                        new BigDecimal("4500"),
                        10
                );

        Produto mouse =
                new Produto(
                        2L,
                        "Mouse",
                        Categoria.ACESSORIO,
                        new BigDecimal("100"),
                        50
                );

        Produto livro =
                new Produto(
                        3L,
                        "Java",
                        Categoria.LIVRO,
                        new BigDecimal("150"),
                        20
                );

        Pedido pedido1 =
                new Pedido(
                        1L,
                        joao,
                        LocalDate.now()
                );

        pedido1.adicionar(
                new ItemPedido(notebook, 1)
        );

        pedido1.adicionar(
                new ItemPedido(mouse, 2)
        );

        Pedido pedido2 =
                new Pedido(
                        2L,
                        maria,
                        LocalDate.now()
                );

        pedido2.adicionar(
                new ItemPedido(livro, 3)
        );

        pedido2.adicionar(
                new ItemPedido(mouse, 5)
        );

        PedidoRepository repository =
                new PedidoRepository();

        repository.salvar(pedido1);
        repository.salvar(pedido2);

        List<Pedido> pedidos =
                repository.listar();

        PedidoService service =
                new PedidoService(
                        new CalculadoraDesconto(),
                        new CalculadoraFrete()
                );

        pedidos.forEach(pedido ->
                System.out.println(
                        service.calcularTotal(pedido)
                )
        );

        Ranking ranking =
                new Ranking();

        System.out.println(
                ranking.clientes(pedidos)
        );

        System.out.println(
                ranking.produtos(pedidos)
        );

        Relatorio relatorio =
                new Relatorio();

        relatorio.imprimir(pedidos);
    }
}