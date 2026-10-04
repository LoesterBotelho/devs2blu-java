package exercicios03102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {

    private double peso;

    public ProdutoFisico(
            Long id,
            String nome,
            BigDecimal preco,
            Categoria categoria,
            double peso) {

        super(id, nome, preco, categoria);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}