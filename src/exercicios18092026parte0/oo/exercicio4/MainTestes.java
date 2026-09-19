package exercicios18092026parte0.oo.exercicio4;

import java.util.List;

public class MainTestes {

    public static void main(String[] args) {
    	
        List<String> nomes = List.of("Ana", "Bruno", "Ana", "Carlos", "Bruno", "Daniel");
        
        List<String> nomesUnicos = RemovedorDuplicadas.removerDuplicadas(nomes);
        
        System.out.println("Lista sem duplicadas: " + nomesUnicos);
        
    }
}