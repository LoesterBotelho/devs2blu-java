package exercicios03102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        RepositorioProduto repositorio = new RepositorioProduto();

        Produto produto1 = new ProdutoFisico(
                1L,
                "Notebook",
                new BigDecimal("4500.00"),
                Categoria.ELETRONICO,
                2.5
        );

        Produto produto2 = new ProdutoFisico(
                2L,
                "Livro Java",
                new BigDecimal("150.00"),
                Categoria.LIVRO,
                0.8
        );

        Produto produto3 = new ProdutoDigital(
                3L,
                "Curso Java",
                new BigDecimal("300.00"),
                Categoria.CURSO,
                5.5
        );

        Produto produto4 = new ProdutoDigital(
                4L,
                "Jogo Java",
                new BigDecimal("200.00"),
                Categoria.JOGO,
                10.0
        );

        repositorio.adicionar(produto1);
        repositorio.adicionar(produto2);
        repositorio.adicionar(produto3);
        repositorio.adicionar(produto4);

        ProdutoService service = new ProdutoService(repositorio);

        System.out.println("TODOS");

        ProdutoUtils.imprimir(repositorio.listar());

        System.out.println();
        System.out.println("CURSOS");

        List<Produto> cursos =
                service.buscarPorCategoria(Categoria.CURSO);

        ProdutoUtils.imprimir(cursos);

        System.out.println();
        System.out.println("PRODUTOS ACIMA DE R$ 250");

        List<Produto> produtosCaros =
                service.buscarPorPreco(new BigDecimal("250.00"));

        ProdutoUtils.imprimir(produtosCaros);

        System.out.println();
        System.out.println("TOTAL");

        System.out.println(service.calcularTotal());

        System.out.println();
        System.out.println("ORDENADO");

        Relatorio relatorio = new Relatorio();

        relatorio.gerar(repositorio.listar());
    }
}