package exercicios28092026parte0.oo.exercicio4;

import java.math.BigDecimal;

public class Venda {

    private final Long id;
    private final Vendedor vendedor;
    private final Produto produto;
    private final int quantidade;
    private final BigDecimal desconto;

    public Venda(
            Long id,
            Vendedor vendedor,
            Produto produto,
            int quantidade,
            BigDecimal desconto) {

        this.id = id;
        this.vendedor = vendedor;
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Long getId() {
        return id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public BigDecimal getValorBruto() {

        return produto.getPreco()
                .multiply(
                        BigDecimal.valueOf(
                                quantidade
                        )
                );
    }

    public BigDecimal getValorDesconto() {

        return getValorBruto()
                .multiply(desconto);
    }

    public BigDecimal getValorLiquido() {

        return getValorBruto()
                .subtract(
                        getValorDesconto()
                );
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", vendedor=" + vendedor.getNome() +
                ", produto=" + produto.getNome() +
                ", quantidade=" + quantidade +
                ", desconto=" + desconto +
                ", valorLiquido=" + getValorLiquido() +
                '}';
    }
}