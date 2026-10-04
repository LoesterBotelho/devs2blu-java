package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class CalculadoraFrete {

    public BigDecimal calcular(Pedido pedido) {

        int quantidade = pedido.getItens()
                .stream()
                .mapToInt(ItemPedido::quantidade)
                .sum();

        if (quantidade >= 10) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf(20 + quantidade * 5L);
    }
}