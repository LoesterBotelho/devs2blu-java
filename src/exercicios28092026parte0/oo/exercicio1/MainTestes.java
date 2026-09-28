package exercicios28092026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainTestes {

    public static void main(String[] args) {

        Produto notebook = new Produto(
                1L,
                "Notebook",
                CategoriaProduto.INFORMATICA,
                new BigDecimal("4500.00"),
                10
        );

        Produto monitor = new Produto(
                2L,
                "Monitor",
                CategoriaProduto.INFORMATICA,
                new BigDecimal("1800.00"),
                5
        );

        Produto teclado = new Produto(
                3L,
                "Teclado Mecânico",
                CategoriaProduto.ACESSORIOS,
                new BigDecimal("450.00"),
                20
        );

        Produto mouse = new Produto(
                4L,
                "Mouse Gamer",
                CategoriaProduto.ACESSORIOS,
                new BigDecimal("250.00"),
                30
        );

        Produto celular = new Produto(
                5L,
                "Smartphone",
                CategoriaProduto.ELETRONICO,
                new BigDecimal("3200.00"),
                8
        );

        Produto tablet = new Produto(
                6L,
                "Tablet",
                CategoriaProduto.ELETRONICO,
                new BigDecimal("2800.00"),
                3
        );

        Produto cadeira = new Produto(
                7L,
                "Cadeira Gamer",
                CategoriaProduto.MOVEIS,
                new BigDecimal("2200.00"),
                4
        );

        Produto mesa = new Produto(
                8L,
                "Mesa Escritório",
                CategoriaProduto.MOVEIS,
                new BigDecimal("1500.00"),
                6
        );

        Produto livroJava = new Produto(
                9L,
                "Java Efetivo",
                CategoriaProduto.LIVROS,
                new BigDecimal("180.00"),
                15
        );

        Produto livroSpring = new Produto(
                10L,
                "Spring Boot",
                CategoriaProduto.LIVROS,
                new BigDecimal("220.00"),
                2
        );

        Estoque estoque = new Estoque();

        estoque.adicionar(notebook);
        estoque.adicionar(monitor);
        estoque.adicionar(teclado);
        estoque.adicionar(mouse);
        estoque.adicionar(celular);
        estoque.adicionar(tablet);
        estoque.adicionar(cadeira);
        estoque.adicionar(mesa);
        estoque.adicionar(livroJava);
        estoque.adicionar(livroSpring);

        System.out.println("TODOS OS PRODUTOS");

        estoque.listar()
                .forEach(System.out::println);

        System.out.println("\nINFORMATICA");

        estoque.listarPorCategoria(
                        CategoriaProduto.INFORMATICA
                )
                .forEach(System.out::println);

        System.out.println("\nESTOQUE BAIXO");

        estoque.listarEstoqueBaixo(5)
                .forEach(System.out::println);

        System.out.println("\nMAIS CARO");

        estoque.produtoMaisCaro()
                .ifPresent(System.out::println);

        System.out.println("\nMAIS BARATO");

        estoque.produtoMaisBarato()
                .ifPresent(System.out::println);

        System.out.println("\nORDENADO POR PRECO");

        estoque.ordenarPorPreco()
                .forEach(System.out::println);

        System.out.println("\nORDENADO POR PRECO DESCENDENTE");

        estoque.ordenarPorPrecoDescendente()
                .forEach(System.out::println);

        System.out.println("\nVALOR TOTAL DO ESTOQUE");

        System.out.println(
                estoque.calcularValorTotal()
        );

        System.out.println("\nAGRUPADO POR CATEGORIA");

        Map<CategoriaProduto, List<Produto>> agrupado =
                estoque.agruparPorCategoria();

        agrupado.forEach(
                (categoria, produtos) -> {

                    System.out.println(
                            "\nCategoria: " + categoria
                    );

                    produtos.forEach(
                            System.out::println
                    );
                }
        );

        System.out.println("\nOPERACOES GENERICAS");

        List<Produto> produtos =
                estoque.listar();

        System.out.println("\nProdutos acima de R$ 1.000:");

        List<Produto> produtosCaros =
                OperacoesGenericas.filtrar(
                        produtos,
                        produto ->
                                produto.getPreco()
                                        .compareTo(
                                                new BigDecimal("1000.00")
                                        ) > 0
                );

        produtosCaros.forEach(
                System.out::println
        );

        System.out.println("\nNomes:");

        List<String> nomes =
                OperacoesGenericas.transformar(
                        produtos,
                        Produto::getNome
                );

        nomes.forEach(
                System.out::println
        );

        System.out.println("\nConsumindo produtos:");

        OperacoesGenericas.consumir(
                produtos,
                produto ->
                        System.out.println(
                                "Produto: " +
                                produto.getNome()
                        )
        );

        System.out.println("\nPECS");

        List<Produto> produtosOrigem =
                estoque.listar();

        List<Object> produtosDestino =
                new ArrayList<>();

        OperacoesGenericas.copiar(
                produtosOrigem,
                produtosDestino
        );

        produtosDestino.forEach(
                System.out::println
        );
    }
}