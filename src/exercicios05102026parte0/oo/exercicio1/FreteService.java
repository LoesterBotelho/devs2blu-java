package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class FreteService {

    public BigDecimal calcular(Pedido pedido) {

        int quantidade =
                pedido.getItens()
                        .stream()
                        .mapToInt(
                                ItemPedido::quantidade
                        )
                        .sum();

        boolean possuiDigital =
                pedido.getItens()
                        .stream()
                        .anyMatch(item ->
                                item.produto()
                                        instanceof ProdutoDigital);

        if (possuiDigital && quantidade == 1) {
            return BigDecimal.ZERO;
        }

        if (quantidade >= 10) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf(
                20 + quantidade * 5L
        );
    }
}