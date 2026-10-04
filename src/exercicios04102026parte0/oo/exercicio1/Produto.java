package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public record Produto(
        Long id,
        String nome,
        Categoria categoria,
        BigDecimal preco,
        int estoque
) {
}