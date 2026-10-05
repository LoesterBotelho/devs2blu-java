package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private LocalDateTime data;
    private StatusPedido status;
    private List<ItemPedido> itens;

    public Pedido(
            Long id,
            Cliente cliente) {

        this.id = id;
        this.cliente = cliente;
        this.data = LocalDateTime.now();
        this.status = StatusPedido.CRIADO;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public BigDecimal subtotal() {

        return itens.stream()
                .map(ItemPedido::subtotal)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return List.copyOf(itens);
    }

    public void alterarStatus(StatusPedido status) {
        this.status = status;
    }
}