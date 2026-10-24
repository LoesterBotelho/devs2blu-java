package exercicios24102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public record Medicamento(String nome, String dosagem, BigDecimal preco) {
	
    public Medicamento {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (dosagem == null || dosagem.isBlank()) {
            throw new IllegalArgumentException("Dosagem obrigatória");
        }

        if (preco == null || preco.signum() < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
    }
    
}