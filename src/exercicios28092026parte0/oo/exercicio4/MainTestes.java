package exercicios28092026parte0.oo.exercicio4;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MainTestes {

    public static void main(String[] args) {

        Vendedor joao =
                new Vendedor(
                        1L,
                        "Joao",
                        Regiao.SUL
                );

        Vendedor maria =
                new Vendedor(
                        2L,
                        "Maria",
                        Regiao.SUDESTE
                );

        Vendedor carlos =
                new Vendedor(
                        3L,
                        "Carlos",
                        Regiao.SUL
                );

        Vendedor ana =
                new Vendedor(
                        4L,
                        "Ana",
                        Regiao.NORDESTE
                );

        Vendedor fernanda =
                new Vendedor(
                        5L,
                        "Fernanda",
                        Regiao.CENTRO_OESTE
                );

        Produto notebook =
                new Produto(
                        1L,
                        "Notebook",
                        "INFORMATICA",
                        new BigDecimal("4500.00")
                );

        Produto monitor =
                new Produto(
                        2L,
                        "Monitor",
                        "INFORMATICA",
                        new BigDecimal("1800.00")
                );

        Produto teclado =
                new Produto(
                        3L,
                        "Teclado",
                        "ACESSORIOS",
                        new BigDecimal("450.00")
                );

        Produto mouse =
                new Produto(
                        4L,
                        "Mouse",
                        "ACESSORIOS",
                        new BigDecimal("250.00")
                );

        Produto celular =
                new Produto(
                        5L,
                        "Celular",
                        "ELETRONICOS",
                        new BigDecimal("3200.00")
                );

        Produto cadeira =
                new Produto(
                        6L,
                        "Cadeira",
                        "MOVEIS",
                        new BigDecimal("2200.00")
                );

        Produto tablet =
                new Produto(
                        7L,
                        "Tablet",
                        "ELETRONICOS",
                        new BigDecimal("2800.00")
                );

        Produto mesa =
                new Produto(
                        8L,
                        "Mesa",
                        "MOVEIS",
                        new BigDecimal("1500.00")
                );

        List<Venda> vendas = List.of(

                new Venda(
                        1L,
                        joao,
                        notebook,
                        3,
                        new BigDecimal("0.05")
                ),

                new Venda(
                        2L,
                        maria,
                        celular,
                        5,
                        new BigDecimal("0.10")
                ),

                new Venda(
                        3L,
                        carlos,
                        monitor,
                        8,
                        new BigDecimal("0.05")
                ),

                new Venda(
                        4L,
                        ana,
                        cadeira,
                        4,
                        new BigDecimal("0.08")
                ),

                new Venda(
                        5L,
                        fernanda,
                        tablet,
                        6,
                        new BigDecimal("0.07")
                ),

                new Venda(
                        6L,
                        joao,
                        teclado,
                        15,
                        new BigDecimal("0.03")
                ),

                new Venda(
                        7L,
                        maria,
                        notebook,
                        4,
                        new BigDecimal("0.06")
                ),

                new Venda(
                        8L,
                        carlos,
                        mouse,
                        20,
                        new BigDecimal("0.04")
                ),

                new Venda(
                        9L,
                        ana,
                        celular,
                        3,
                        new BigDecimal("0.05")
                ),

                new Venda(
                        10L,
                        fernanda,
                        mesa,
                        5,
                        new BigDecimal("0.10")
                ),

                new Venda(
                        11L,
                        joao,
                        monitor,
                        10,
                        new BigDecimal("0.05")
                ),

                new Venda(
                        12L,
                        maria,
                        tablet,
                        7,
                        new BigDecimal("0.08")
                )
        );

        System.out.println("TODAS AS VENDAS");

        vendas.forEach(
                System.out::println
        );

        System.out.println("\nFATURAMENTO TOTAL");

        System.out.println(
                AnalisadorVendas.faturamentoTotal(
                        vendas
                )
        );

        System.out.println("\nMAIOR VENDA");

        AnalisadorVendas.maiorVenda(
                        vendas
                )
                .ifPresent(
                        System.out::println
                );

        System.out.println("\nMENOR VENDA");

        AnalisadorVendas.menorVenda(
                        vendas
                )
                .ifPresent(
                        System.out::println
                );

        System.out.println("\nVENDAS ORDENADAS");

        AnalisadorVendas.ordenarPorValorDescendente(
                        vendas
                )
                .forEach(
                        System.out::println
                );

        System.out.println("\nFATURAMENTO POR VENDEDOR");

        Map<Vendedor, BigDecimal> porVendedor =
                AnalisadorVendas.faturamentoPorVendedor(
                        vendas
                );

        porVendedor.forEach(
                (vendedor, valor) ->
                        System.out.println(
                                vendedor.getNome() +
                                " -> " +
                                valor
                        )
        );

        System.out.println("\nFATURAMENTO POR REGIAO");

        Map<Regiao, BigDecimal> porRegiao =
                AnalisadorVendas.faturamentoPorRegiao(
                        vendas
                );

        porRegiao.forEach(
                (regiao, valor) ->
                        System.out.println(
                                regiao +
                                " -> " +
                                valor
                        )
        );

        System.out.println("\nFATURAMENTO POR CATEGORIA");

        Map<String, BigDecimal> porCategoria =
                AnalisadorVendas.faturamentoPorCategoria(
                        vendas
                );

        porCategoria.forEach(
                (categoria, valor) ->
                        System.out.println(
                                categoria +
                                " -> " +
                                valor
                        )
        );

        System.out.println("\nQUANTIDADE POR PRODUTO");

        Map<String, Long> quantidadePorProduto =
                AnalisadorVendas.quantidadePorProduto(
                        vendas
                );

        quantidadePorProduto.forEach(
                (produto, quantidade) ->
                        System.out.println(
                                produto +
                                " -> " +
                                quantidade
                        )
        );

        System.out.println("\nPRODUTOS VENDIDOS");

        AnalisadorVendas.produtosVendidos(
                        vendas
                )
                .forEach(
                        System.out::println
                );
    }
}