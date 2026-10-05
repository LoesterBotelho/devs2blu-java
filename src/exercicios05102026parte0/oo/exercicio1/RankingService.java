package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankingService {

    public List<Map.Entry<Produto, Integer>>
    produtosMaisVendidos(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .flatMap(pedido ->
                        pedido.getItens()
                                .stream())
                .collect(
                        Collectors.groupingBy(
                                ItemPedido::produto,
                                Collectors.summingInt(
                                        ItemPedido::quantidade
                                )
                        )
                )
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry
                                .<Produto, Integer>
                                comparingByValue()
                                .reversed()
                )
                .toList();
    }

    public List<Map.Entry<Cliente, BigDecimal>>
    clientesMaisRentaveis(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .collect(
                        Collectors.groupingBy(
                                Pedido::getCliente,

                                Collectors.mapping(
                                        Pedido::subtotal,

                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                )
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry
                                .<Cliente, BigDecimal>
                                comparingByValue()
                                .reversed()
                )
                .toList();
    }
}