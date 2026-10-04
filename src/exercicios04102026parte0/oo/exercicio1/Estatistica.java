package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class Estatistica {

    public BigDecimal faturamento(List<Pedido> pedidos) {

        return pedidos.stream()
                .map(Pedido::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public double mediaPedidos(List<Pedido> pedidos) {

        return pedidos.stream()
                .mapToDouble(pedido ->
                        pedido.subtotal().doubleValue())
                .average()
                .orElse(0);
    }
}