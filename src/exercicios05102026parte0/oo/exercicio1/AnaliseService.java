package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnaliseService {

    public BigDecimal faturamento(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .map(Pedido::subtotal)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public Map<Categoria, BigDecimal>
    faturamentoPorCategoria(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .flatMap(pedido ->
                        pedido.getItens()
                                .stream())
                .collect(
                        Collectors.groupingBy(
                                item ->
                                        item.produto()
                                                .getCategoria(),

                                Collectors.mapping(
                                        ItemPedido::subtotal,

                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public Map<TipoCliente, Long>
    pedidosPorTipoCliente(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .collect(
                        Collectors.groupingBy(
                                pedido ->
                                        pedido.getCliente()
                                                .tipo(),

                                Collectors.counting()
                        )
                );
    }
}