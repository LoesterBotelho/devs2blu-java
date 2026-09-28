package exercicios27092026parte0.oo.exercicio1;

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

    public BigDecimal getValorTotal() {
        return produto.getPreco()
                .multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return String.format(
                "ItemPedido{produto='%s', quantidade=%d, total=R$ %.2f}",
                produto.getNome(),
                quantidade,
                getValorTotal()
        );
    }
}