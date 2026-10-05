package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Entrega(
        Long id,
        Pedido pedido,
        Endereco endereco,
        BigDecimal frete,
        StatusEntrega status,
        LocalDateTime previsao
) {
}