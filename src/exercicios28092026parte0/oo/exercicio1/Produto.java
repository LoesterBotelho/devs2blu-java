package exercicios28092026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class Produto {

    private final Long id;
    private final String nome;
    private final CategoriaProduto categoria;
    private final BigDecimal preco;
    private final int quantidade;

    public Produto(
            Long id,
            String nome,
            CategoriaProduto categoria,
            BigDecimal preco,
            int quantidade) {

        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorTotalEstoque() {
        return preco.multiply(
                BigDecimal.valueOf(quantidade)
        );
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}