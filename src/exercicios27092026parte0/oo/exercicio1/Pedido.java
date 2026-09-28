package exercicios27092026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {

    private final Long id;
    private final Cliente cliente;
    private final List<ItemPedido> itens;
    private final StatusPedido status;

    public Pedido(
            Long id,
            Cliente cliente,
            List<ItemPedido> itens,
            StatusPedido status) {

        this.id = id;
        this.cliente = cliente;
        this.itens = List.copyOf(itens);
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public BigDecimal getValorTotal() {
        return itens.stream()
                .map(ItemPedido::getValorTotal)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    @Override
    public String toString() {
        return String.format(
                "Pedido{id=%d, cliente='%s', status=%s, total=R$ %.2f}",
                id,
                cliente.getNome(),
                status,
                getValorTotal()
        );
    }
}