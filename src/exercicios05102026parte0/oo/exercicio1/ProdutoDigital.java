package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto {

    private double tamanhoMb;

    public ProdutoDigital(
            Long id,
            String nome,
            Categoria categoria,
            BigDecimal preco,
            double tamanhoMb) {

        super(id, nome, categoria, preco);
        this.tamanhoMb = tamanhoMb;
    }

    public double getTamanhoMb() {
        return tamanhoMb;
    }
}