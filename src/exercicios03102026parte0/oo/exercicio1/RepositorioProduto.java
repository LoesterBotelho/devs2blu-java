package exercicios03102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class RepositorioProduto implements Repositorio<Produto> {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    @Override
    public List<Produto> listar() {
        return produtos;
    }
}