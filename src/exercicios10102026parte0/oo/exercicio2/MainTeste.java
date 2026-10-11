package exercicios10102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.Comparator;

public class MainTeste {

    public static void main(String[] args) {
    	
        Estoque<Produto> estoque = new Estoque<>();

        estoque.adicionar(new Produto(
                "P001", "Teclado", new BigDecimal("150.00")));

        estoque.adicionar(new Produto(
                "P002", "Mouse", new BigDecimal("80.00")));

        estoque.adicionar(new Produto(
                "P003", "Monitor", new BigDecimal("900.00")));

        System.out.println("\nPRODUTOS");
        estoque.listar().forEach(System.out::println);

        System.out.println("\nPRODUTOS POR PREÇO");
        estoque.listar().stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .forEach(System.out::println);

        System.out.println("\nPRODUTOS ACIMA DE R$ 100");
        estoque.listar().stream()
                .filter(produto -> produto.getPreco()
                        .compareTo(new BigDecimal("100.00")) > 0)
                .forEach(System.out::println);

        System.out.println("\nBUSCAR PRODUTO");
        estoque.buscar("P002").ifPresent(System.out::println);

        System.out.println("\nREMOVER PRODUTO");
        System.out.println(estoque.remover("P001"));

        System.out.println("\nTotal: " + estoque.tamanho());
    }
    
}