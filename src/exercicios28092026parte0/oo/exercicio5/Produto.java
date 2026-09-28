package exercicios28092026parte0.oo.exercicio5;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private final Long id;
    private final String nome;
    private final String categoria;
    private final BigDecimal preco;

    public Produto(Long id, String nome, String categoria, BigDecimal preco) {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Produto produto)) {
            return false;
        }

        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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