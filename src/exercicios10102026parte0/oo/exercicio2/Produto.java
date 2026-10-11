package exercicios10102026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Produto {
	
    private final String codigo;
    private final String nome;
    private final BigDecimal preco;

    public Produto(String codigo, String nome, BigDecimal preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " - R$ " + preco;
    }
    
}