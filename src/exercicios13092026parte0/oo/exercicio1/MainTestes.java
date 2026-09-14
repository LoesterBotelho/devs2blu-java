package exercicios13092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class MainTestes {

	public static final String MSG_PADRAO = "\n------------------------------------------------------------------------------------------";
	
    public static void main(String[] args) {
    	
        Catalogo<Produto> catalogoProdutos = new Catalogo<>();

        // ------------------------------------------------------------------------------------------
        
        Produto notebook = new Produto(1L, "Notebook", 4500.00);
        Produto mouse = new Produto(2L, "Mouse", 150.00);
        Produto teclado = new Produto(3L, "Teclado", 300.00);
        Produto monitor = new Produto(4L, "Monitor", 1800.00);

        catalogoProdutos.adicionar(notebook);
        catalogoProdutos.adicionar(mouse);
        catalogoProdutos.adicionar(teclado);
        catalogoProdutos.adicionar(monitor);

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("TESTE 1: LISTAR PRODUTOS");

        catalogoProdutos.listar()
                .forEach(produto ->
                        System.out.println(
                                produto.nome() + " - R$ " + produto.preco()
                        )
                );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 2: PRODUTO MAIS CARO");

        catalogoProdutos.buscarMaisCaro()
                .ifPresent(produto ->
                        System.out.println(
                                produto.nome() + " - R$ " + produto.preco()
                        )
                );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 3: PRODUTOS ACIMA DE R$ 1000");

        catalogoProdutos.filtrar(
                        produto -> produto.getPreco() > 1000
                )
                .forEach(produto ->
                        System.out.println(
                                produto.nome() + " - R$ " + produto.preco()
                        )
                );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 4: MAPEAMENTO");

        List<String> nomes = catalogoProdutos.mapear(
                produto -> produto.nome() + " - R$ " + produto.preco()
        );

        nomes.forEach(System.out::println);

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 5: PRODUTOS DIGITAIS");

        Catalogo<ProdutoDigital> catalogoDigitais = new Catalogo<>();

        ProdutoDigital java = new ProdutoDigital(
                1L,
                "Java Course",
                199.90,
                850
        );

        ProdutoDigital spring = new ProdutoDigital(
                2L,
                "Spring Course",
                249.90,
                1200
        );

        ProdutoDigital docker = new ProdutoDigital(
                3L,
                "Docker Course",
                149.90,
                600
        );

        catalogoDigitais.adicionar(java);
        catalogoDigitais.adicionar(spring);
        catalogoDigitais.adicionar(docker);

        catalogoDigitais.listar()
                .forEach(produto ->
                        System.out.println(
                                produto.nome()
                                        + " - R$ "
                                        + produto.preco()
                                        + " - "
                                        + produto.tamanhoMb()
                                        + " MB"
                        )
                );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 6: PRODUTOS FÍSICOS");

        Catalogo<ProdutoFisico> catalogoFisicos = new Catalogo<>();

        ProdutoFisico notebookFisico = new ProdutoFisico(
                1L,
                "Notebook",
                4500.00,
                2.5
        );

        ProdutoFisico monitorFisico = new ProdutoFisico(
                2L,
                "Monitor",
                1800.00,
                4.0
        );

        ProdutoFisico tecladoFisico = new ProdutoFisico(
                3L,
                "Teclado",
                300.00,
                0.8
        );

        catalogoFisicos.adicionar(notebookFisico);
        catalogoFisicos.adicionar(monitorFisico);
        catalogoFisicos.adicionar(tecladoFisico);

        catalogoFisicos.listar()
                .forEach(produto ->
                        System.out.println(
                                produto.nome()
                                        + " - R$ "
                                        + produto.preco()
                                        + " - "
                                        + produto.peso()
                                        + " kg"
                        )
                );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 7: VALOR TOTAL");

        double total = CatalogoUtil.calcularValorTotal(
                catalogoProdutos.listar()
        );

        System.out.println("Valor total: R$ " + total);

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 8: MAIOR PREÇO");

        CatalogoUtil.maiorPreco(catalogoProdutos.listar())
                .ifPresent(produto ->
                        System.out.println(
                                produto.nome() + " - R$ " + produto.preco()
                        )
                );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 9: CONSUMER SUPER");

        List<Precificavel> destino = new ArrayList<>();
        List<Produto> origem = catalogoProdutos.listar();

        CatalogoUtil.adicionarTodos(destino, origem);

        System.out.println(
                "Itens adicionados: " + destino.size()
        );

        // ------------------------------------------------------------------------------------------
    }

}