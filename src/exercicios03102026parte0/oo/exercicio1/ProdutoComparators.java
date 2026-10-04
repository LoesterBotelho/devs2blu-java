package exercicios03102026parte0.oo.exercicio1;

import java.util.Comparator;

public class ProdutoComparators {

    public static Comparator<Produto> porNome() {

        return Comparator.comparing(Produto::getNome);
    }

    public static Comparator<Produto> porPreco() {

        return Comparator.comparing(Produto::getPreco);
    }
}