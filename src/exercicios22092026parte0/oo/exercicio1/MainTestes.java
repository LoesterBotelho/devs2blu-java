package exercicios22092026parte0.oo.exercicio1;

import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

    	// -----------------------------------------------------------------------------------------------------
    	
        Repositorio<Produto> repositorio = new Repositorio<>();
        
        // -----------------------------------------------------------------------------------------------------
        
        repositorio.adicionar(
                new Produto("Notebook", 4500.00, "Eletrônicos")
        );

        repositorio.adicionar(
                new Produto("Mouse", 150.00, "Eletrônicos")
        );

        repositorio.adicionar(
                new Produto("Livro Java Avançado", 90.00, "Livros")
        );

        repositorio.adicionar(
                new Produto("Cadeira Gamer", 1200.00, "Móveis")
        );

        repositorio.adicionar(
                new Produto("Teclado Mecânico", 350.00, "Eletrônicos")
        );

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n1. TODOS OS PRODUTOS (forEach com Lambda) ");

        repositorio.listarTodos()
                .forEach(produto -> System.out.println(produto));

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n2. FILTRANDO: Eletrônicos abaixo de R$ 1000 ");

        List<Produto> eletronicosBaratos = repositorio.filtrar(
                p -> p.getCategoria().equals("Eletrônicos")
                        && p.getPreco() < 1000.00
        );

        eletronicosBaratos.forEach(System.out::println);

        
        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n3. ORDENANDO POR PREÇO CRESCENTE (Lambda + Comparator) ");

        List<Produto> todos = repositorio.listarTodos();

        todos.sort(
                (p1, p2) -> Double.compare(
                        p1.getPreco(),
                        p2.getPreco()
                )
        );

        todos.forEach(
                p -> System.out.println(
                        p.getNome() + " - R$ " + p.getPreco()
                )
        );
        
        // -----------------------------------------------------------------------------------------------------
        
    }
}