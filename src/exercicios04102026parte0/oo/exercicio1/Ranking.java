package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;
// import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranking {

    public List<Map.Entry<Cliente, BigDecimal>> clientes(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getCliente,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Pedido::subtotal,
                                BigDecimal::add
                        )
                ))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<Cliente, BigDecimal>comparingByValue()
                                .reversed()
                )
                .toList();
    }

    public List<Map.Entry<Produto, Integer>> produtos(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .flatMap(pedido ->
                        pedido.getItens().stream())
                .collect(Collectors.groupingBy(
                        ItemPedido::produto,
                        Collectors.summingInt(ItemPedido::quantidade)
                ))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<Produto, Integer>comparingByValue()
                                .reversed()
                )
                .toList();
    }
}