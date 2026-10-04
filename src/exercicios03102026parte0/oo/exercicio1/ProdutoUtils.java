package exercicios03102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoUtils {

    public static <T extends Produto> BigDecimal calcularTotal(List<T> produtos) {

        return produtos.stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static <T extends Produto> void imprimir(List<T> produtos) {

        produtos.forEach(System.out::println);
    }
}