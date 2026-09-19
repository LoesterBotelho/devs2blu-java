package exercicios18092026parte0.oo.exercicio5;

import java.util.HashMap;
import java.util.Map;

public class ControleEstoque {

    public static void main(String[] args) {
    	
        // Criando o Map
        Map<String, Integer> estoque = new HashMap<>();

        // Adicionando produtos (Chave = Nome, Valor = Quantidade)
        estoque.put("Notebook", 15);
        estoque.put("Mouse", 50);
        estoque.put("Teclado", 30);

        // Atualizando um valor (Mouse passou de 50 para 45)
        estoque.put("Mouse", 45); 
        
        // Ou usando replace / putIfAbsent se preferir

        // Percorrendo o Map
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("RELATÓRIO DE ESTOQUE : \n");
        
        for (Map.Entry<String, Integer> entry : estoque.entrySet()) {
            System.out.println("Produto: " + entry.getKey() + " | Qtd: " + entry.getValue());
        }
        
    }
}