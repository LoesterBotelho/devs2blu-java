package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Pagamento(
        Long id,
        Pedido pedido,
        BigDecimal valor,
        FormaPagamento formaPagamento,
        StatusPagamento status,
        LocalDateTime data
) {
}