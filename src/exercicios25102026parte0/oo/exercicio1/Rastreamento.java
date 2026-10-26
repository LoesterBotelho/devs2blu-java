package exercicios25102026parte0.oo.exercicio1;

import java.time.LocalDateTime;

public record Rastreamento(
        String encomendaId,
        StatusEntrega status,
        LocalDateTime dataHora,
        String descricao) {

    public Rastreamento {
        if (encomendaId == null || encomendaId.isBlank()
                || status == null
                || dataHora == null
                || descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException(
                    "Dados de rastreamento inválidos");
        }
    }
}