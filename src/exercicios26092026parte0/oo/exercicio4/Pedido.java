package exercicios26092026parte0.oo.exercicio4;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {

    private final String idPedido;
    private final String cliente;
    private final StatusPedido status;
    private final List<ItemPedido> itens;

    public Pedido(
            String idPedido,
            String cliente,
            StatusPedido status,
            List<ItemPedido> itens) {

        this.idPedido = idPedido;
        this.cliente = cliente;
        this.status = status;
        this.itens = List.copyOf(itens);
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public BigDecimal getValorTotalPedido() {
        return itens.stream()
                .map(ItemPedido::getValorTotalItem)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    @Override
    public String toString() {
        return String.format(
                "Pedido{id='%s', cliente='%s', status=%s, valorTotal=R$ %.2f}",
                idPedido,
                cliente,
                status,
                getValorTotalPedido()
        );
    }
}