package exercicios03102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto {

    private double tamanho;

    public ProdutoDigital(
            Long id,
            String nome,
            BigDecimal preco,
            Categoria categoria,
            double tamanho) {

        super(id, nome, preco, categoria);
        this.tamanho = tamanho;
    }

    public double getTamanho() {
        return tamanho;
    }
}