package exercicios28092026parte0.oo.exercicio4;

import java.math.BigDecimal;

public class Produto {

    private final Long id;
    private final String nome;
    private final String categoria;
    private final BigDecimal preco;

    public Produto(
            Long id,
            String nome,
            String categoria,
            BigDecimal preco) {

        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                '}';
    }
}