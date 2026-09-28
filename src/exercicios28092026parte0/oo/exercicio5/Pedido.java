package exercicios28092026parte0.oo.exercicio5;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
                .map(ItemPedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getQuantidadeItens() {
        return itens.stream()
                .mapToInt(ItemPedido::getQuantidade)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pedido pedido)) {
            return false;
        }

        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", status=" + status +
                ", valorTotal=" + getValorTotal() +
                '}';
    }
}