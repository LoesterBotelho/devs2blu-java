package exercicios04102026parte0.oo.exercicio1;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PedidoProcessor {

    public void processar(
            List<Pedido> pedidos,
            Predicate<Pedido> filtro,
            Consumer<Pedido> acao) {

        pedidos.stream()
                .filter(filtro)
                .forEach(acao);
    }
}