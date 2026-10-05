package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public record ItemPedido(
        Produto produto,
        int quantidade
) {

    public BigDecimal subtotal() {

        return produto.getPreco()
                .multiply(BigDecimal.valueOf(quantidade));
    }
}