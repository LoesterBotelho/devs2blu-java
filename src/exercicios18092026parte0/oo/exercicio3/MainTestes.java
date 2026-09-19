package exercicios18092026parte0.oo.exercicio3;

import java.util.List;

public class MainTestes {
	
	public static void main(String[] args) {
		
        // Testando com lista de Inteiros
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);
        System.out.println("--- Lista de Números ---");
        ImpressoraDeListas.imprimirLista(numeros);

        // Testando com lista de Strings
        List<String> frutas = List.of("Maçã", "Banana", "Laranja");
        System.out.println("--- Lista de Frutas ---");
        ImpressoraDeListas.imprimirLista(frutas);
        
    }
}