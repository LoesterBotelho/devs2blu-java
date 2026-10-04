package exercicios04102026parte0.oo.exercicio1;

import java.util.List;

public class Relatorio {

    public void imprimir(List<Pedido> pedidos) {

        pedidos.stream()
                .sorted(
                        (a, b) ->
                                b.subtotal()
                                        .compareTo(a.subtotal())
                )
                .forEach(pedido ->
                        System.out.println(
                                pedido.getId()
                                        + " - "
                                        + pedido.getCliente().nome()
                                        + " - "
                                        + pedido.subtotal()
                        )
                );
    }
}