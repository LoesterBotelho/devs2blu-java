package exercicios03102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> listar() {
        return produtos;
    }

    public int quantidade() {
        return produtos.size();
    }
}