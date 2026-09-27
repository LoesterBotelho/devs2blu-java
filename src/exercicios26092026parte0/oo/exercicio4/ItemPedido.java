package exercicios26092026parte0.oo.exercicio4;

import java.math.BigDecimal;

public class ItemPedido {

    private final String nomeProduto;
    private final String categoria;
    private final BigDecimal precoUnitario;
    private final int quantidade;

    public ItemPedido(
            String nomeProduto,
            String categoria,
            BigDecimal precoUnitario,
            int quantidade) {

        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorTotalItem() {
        return precoUnitario.multiply(
                BigDecimal.valueOf(quantidade)
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Item{produto='%s', categoria='%s', total=R$ %.2f}",
                nomeProduto,
                categoria,
                getValorTotalItem()
        );
    }
}