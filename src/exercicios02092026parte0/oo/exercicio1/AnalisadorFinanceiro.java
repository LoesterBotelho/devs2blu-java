package exercicios02092026parte0.oo.exercicio1;

import java.util.List;

class AnalisadorFinanceiro {

	// Wildcard (<? extends Number>): Aceita qualquer lista de números (Double, Integer, etc.).
    // Exemplo em texto: É como aceitar qualquer tipo de cédula de dinheiro (R$ 2, R$ 5, R$ 10) na contagem.	
    public static double calcularSomaRetornos(List<? extends Number> valores) {
        double soma = 0.0;

        // O uso do wildcard garante leitura segura utilizando métodos da classe Number
        for (Number n : valores) {
        	
        	// Unboxing implícito do Wrapper para primitivo
            soma += n.doubleValue(); 
        }
        return soma;
    }
}