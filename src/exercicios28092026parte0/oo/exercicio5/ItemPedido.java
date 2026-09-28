package exercicios28092026parte0.oo.exercicio5;

import java.math.BigDecimal;

public class ItemPedido {

    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubtotal() {
        return produto.getPreco()
                .multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto.getNome() +
                ", quantidade=" + quantidade +
                ", subtotal=" + getSubtotal() +
                '}';
    }
}