package exercicios21082026.collections;

import java.util.*;
import java.util.stream.Collectors;

public class MainCollectionsCompleto {
    public static void main(String[] args) {
    	
    	
        System.out.println("");


        
        GerenciadorEstoque estoque = new GerenciadorEstoque();

        
        
        
        // 1. Populando dados
        System.out.println("");
        estoque.adicionarProduto(new Produto(101, "Notebook Gamer", 4500.00), "Eletrônicos");
        estoque.adicionarProduto(new Produto(102, "Mouse Sem Fio", 120.00), "Acessórios");
        estoque.adicionarProduto(new Produto(103, "Teclado Mecânico", 350.00), "Acessórios");
        estoque.adicionarProduto(new Produto(104, "Monitor Ultrawide", 1800.00), "Eletrônicos");

        // Adicionando duplicata de categoria para provar o Set (HashSet não duplica)
        estoque.adicionarProduto(new Produto(105, "Headset", 250.00), "Eletrônicos");

        // Populando a Fila de Pedidos (Queue)
        estoque.adicionarPedido("Carlos Silva");
        estoque.adicionarPedido("Ana Beatriz");
        estoque.adicionarPedido("Marcos Souza");

        
        
        
        // 2. Executando a exibição estruturada das Collections
        System.out.println("");
        estoque.exibirListas();

        
        
        
        // 3. Demonstração de Busca O(1) usando o Map
        System.out.println("");
        {
            System.out.println("\n--- [BUSCA NO MAP] Buscando produto ID 103 ---");
            Produto pBuscado = estoque.buscarNoMapa(103);
            System.out.println(pBuscado != null ? pBuscado : "Produto não encontrado.");
        }

        
        
        
        // 4. Filtragem avançada combinando Collections e Streams API com Lambda
        System.out.println("");
        System.out.println("\n--- [STREAM & LAMBDA] Produtos com preço acima de R$ 500.00 ---");
        // Aqui usamos List convertida em Stream, filtrando com Predicate via Lambda
        List<Produto> produtosCaros = estoque.buscarNoMapa(101) != null ? 
            // Simulando filtro direto nos dados armazenados
            java.util.Arrays.asList(
                new Produto(101, "Notebook Gamer", 4500.00),
                new Produto(102, "Mouse Sem Fio", 120.00),
                new Produto(103, "Teclado Mecânico", 350.00),
                new Produto(104, "Monitor Ultrawide", 1800.00),
                new Produto(105, "Headset", 250.00)
            ).stream()
             .filter(p -> p.getPreco() > 500.00) // Expressão Lambda
             .collect(Collectors.toList()) : new ArrayList<>();

        produtosCaros.forEach(System.out::println); // Method Reference

        
        
        
        // 5. Ordenação customizada com TreeSet e Comparator em Lambda
        System.out.println("");
        System.out.println("\n--- [TREE SET] Produtos ordenados por Preço (Decrescente) ---");
        Set<Produto> produtosOrdenadosPorPreco = new TreeSet<>((p1, p2) -> Double.compare(p2.getPreco(), p1.getPreco()));
        produtosOrdenadosPorPreco.addAll(produtosCaros);
        // Adicionando os demais para o TreeSet refletir
        produtosOrdenadosPorPreco.add(new Produto(102, "Mouse Sem Fio", 120.00));
        produtosOrdenadosPorPreco.add(new Produto(103, "Teclado Mecânico", 350.00));

        produtosOrdenadosPorPreco.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("   EXECUÇÃO COMPLETA DE TODAS AS ESTRUTURAS OK");
        System.out.println("");
    }
}