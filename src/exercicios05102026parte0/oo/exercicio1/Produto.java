package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class Produto {

    private Long id;
    private String nome;
    private Categoria categoria;
    private BigDecimal preco;

    public Produto(
            Long id,
            String nome,
            Categoria categoria,
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

    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}