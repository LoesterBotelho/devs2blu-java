package exercicios03102026parte0.oo.exercicio1;

import java.util.List;

public class Relatorio {

    public void gerar(List<Produto> produtos) {

        produtos.stream()
                .sorted(ProdutoComparators.porNome())
                .forEach(System.out::println);

        System.out.println("Quantidade: " + produtos.size());
    }
}