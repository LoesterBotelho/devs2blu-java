package exercicios05102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Map;

public class RelatorioService {

    public void imprimirPedidos(
            List<Pedido> pedidos) {

        pedidos.stream()
                .sorted(
                        (a, b) ->
                                b.subtotal()
                                        .compareTo(
                                                a.subtotal()
                                        )
                )
                .forEach(pedido ->
                        System.out.println(
                                pedido.getId()
                                        + " | "
                                        + pedido.getCliente()
                                                .nome()
                                        + " | R$ "
                                        + pedido.subtotal()
                        )
                );
    }

    public void imprimirRankingProdutos(
            List<Map.Entry<Produto, Integer>>
                    ranking) {

        ranking.forEach(entry ->
                System.out.println(
                        entry.getKey()
                                .getNome()
                                + " -> "
                                + entry.getValue()
                )
        );
    }

    public void imprimirRankingClientes(
            List<Map.Entry<Cliente, java.math.BigDecimal>>
                    ranking) {

        ranking.forEach(entry ->
                System.out.println(
                        entry.getKey()
                                .nome()
                                + " -> R$ "
                                + entry.getValue()
                )
        );
    }
}