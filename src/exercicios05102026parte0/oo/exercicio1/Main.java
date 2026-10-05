package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Cliente joao =
                new Cliente(
                        1L,
                        "Joao",
                        "joao@email.com",
                        TipoCliente.VIP,
                        new Endereco(
                                "Blumenau",
                                "SC",
                                "89000-000"
                        )
                );

        Cliente maria =
                new Cliente(
                        2L,
                        "Maria",
                        "maria@email.com",
                        TipoCliente.PREMIUM,
                        new Endereco(
                                "Florianopolis",
                                "SC",
                                "88000-000"
                        )
                );

        Cliente pedro =
                new Cliente(
                        3L,
                        "Pedro",
                        "pedro@email.com",
                        TipoCliente.COMUM,
                        new Endereco(
                                "Joinville",
                                "SC",
                                "89000-100"
                        )
                );

        Produto notebook =
                new ProdutoFisico(
                        1L,
                        "Notebook",
                        Categoria.INFORMATICA,
                        new BigDecimal("4500"),
                        2.5
                );

        Produto mouse =
                new ProdutoFisico(
                        2L,
                        "Mouse",
                        Categoria.ACESSORIO,
                        new BigDecimal("150"),
                        0.2
                );

        Produto teclado =
                new ProdutoFisico(
                        3L,
                        "Teclado",
                        Categoria.ACESSORIO,
                        new BigDecimal("300"),
                        0.8
                );

        Produto curso =
                new ProdutoDigital(
                        4L,
                        "Curso Java",
                        Categoria.SOFTWARE,
                        new BigDecimal("500"),
                        1500
                );

        Produto livro =
                new ProdutoFisico(
                        5L,
                        "Java Avancado",
                        Categoria.LIVRO,
                        new BigDecimal("200"),
                        1.0
                );

        ProdutoRepository produtoRepository =
                new ProdutoRepository();

        produtoRepository.salvar(notebook);
        produtoRepository.salvar(mouse);
        produtoRepository.salvar(teclado);
        produtoRepository.salvar(curso);
        produtoRepository.salvar(livro);

        EstoqueService estoque =
                new EstoqueService();

        estoque.adicionar(notebook, 10);
        estoque.adicionar(mouse, 50);
        estoque.adicionar(teclado, 30);
        estoque.adicionar(curso, 100);
        estoque.adicionar(livro, 40);

        Pedido pedido1 =
                new Pedido(
                        1L,
                        joao
                );

        pedido1.adicionarItem(
                new ItemPedido(
                        notebook,
                        1
                )
        );

        pedido1.adicionarItem(
                new ItemPedido(
                        mouse,
                        2
                )
        );

        Pedido pedido2 =
                new Pedido(
                        2L,
                        maria
                );

        pedido2.adicionarItem(
                new ItemPedido(
                        curso,
                        2
                )
        );

        pedido2.adicionarItem(
                new ItemPedido(
                        livro,
                        2
                )
        );

        Pedido pedido3 =
                new Pedido(
                        3L,
                        pedro
                );

        pedido3.adicionarItem(
                new ItemPedido(
                        teclado,
                        3
                )
        );

        pedido3.adicionarItem(
                new ItemPedido(
                        mouse,
                        4
                )
        );

        PedidoRepository pedidoRepository =
                new PedidoRepository();

        pedidoRepository.salvar(pedido1);
        pedidoRepository.salvar(pedido2);
        pedidoRepository.salvar(pedido3);

        MarketplaceService marketplace =
                new MarketplaceService(
                        estoque,
                        new DescontoService(),
                        new FreteService(),
                        new PagamentoService()
                );

        marketplace.finalizarPedido(
                pedido1,
                FormaPagamento.PIX,
                1L
        );

        marketplace.finalizarPedido(
                pedido2,
                FormaPagamento.CARTAO_CREDITO,
                2L
        );

        marketplace.finalizarPedido(
                pedido3,
                FormaPagamento.PIX,
                3L
        );

        List<Pedido> pedidos =
                pedidoRepository.listar();

        AnaliseService analise =
                new AnaliseService();

        System.out.println(
                "FATURAMENTO"
        );

        System.out.println(
                analise.faturamento(pedidos)
        );

        System.out.println(
                "FATURAMENTO POR CATEGORIA"
        );

        System.out.println(
                analise.faturamentoPorCategoria(
                        pedidos
                )
        );

        System.out.println(
                "PEDIDOS POR TIPO DE CLIENTE"
        );

        System.out.println(
                analise.pedidosPorTipoCliente(
                        pedidos
                )
        );

        RankingService ranking =
                new RankingService();

        RelatorioService relatorio =
                new RelatorioService();

        System.out.println(
                "PRODUTOS MAIS VENDIDOS"
        );

        relatorio.imprimirRankingProdutos(
                ranking.produtosMaisVendidos(
                        pedidos
                )
        );

        System.out.println(
                "CLIENTES MAIS RENTAVEIS"
        );

        relatorio.imprimirRankingClientes(
                ranking.clientesMaisRentaveis(
                        pedidos
                )
        );

        System.out.println(
                "PEDIDOS"
        );

        relatorio.imprimirPedidos(
                pedidos
        );

        Produto maiorProduto =
                CollectionUtils.maiorPor(
                        produtoRepository.listar(),
                        Produto::getPreco
                );

        System.out.println(
                "PRODUTO MAIS CARO"
        );

        System.out.println(
                maiorProduto.getNome()
        );
    }
}