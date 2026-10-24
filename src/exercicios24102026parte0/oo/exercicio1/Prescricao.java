package exercicios24102026parte0.oo.exercicio1;

import java.time.LocalDate;
import java.util.List;

public record Prescricao(
		
        Long id,
        String orientacoes,
        LocalDate data,
        List<Medicamento> medicamentos) {

    public Prescricao {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        if (orientacoes == null || orientacoes.isBlank()) {
            throw new IllegalArgumentException("Orientações obrigatórias");
        }

        if (data == null || data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data inválida");
        }

        medicamentos = List.copyOf(medicamentos);
    }
    
}