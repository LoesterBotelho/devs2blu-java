package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {

    private double peso;

    public ProdutoFisico(
            Long id,
            String nome,
            Categoria categoria,
            BigDecimal preco,
            double peso) {

        super(id, nome, categoria, preco);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}