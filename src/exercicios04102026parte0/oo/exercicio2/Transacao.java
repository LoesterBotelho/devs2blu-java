package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transacao(
        Long id,
        Conta conta,
        TipoTransacao tipo,
        BigDecimal valor,
        LocalDateTime data,
        StatusTransacao status
) {
}