package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private LocalDate data;
    private StatusPedido status;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(
            Long id,
            Cliente cliente,
            LocalDate data) {

        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.status = StatusPedido.CRIADO;
    }

    public void adicionar(ItemPedido item) {
        itens.add(item);
    }

    public BigDecimal subtotal() {

        return itens.stream()
                .map(ItemPedido::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}