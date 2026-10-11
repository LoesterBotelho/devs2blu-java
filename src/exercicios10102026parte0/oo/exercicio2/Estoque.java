package exercicios10102026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Estoque<T extends Produto> {
	
    private final Map<String, T> produtos = new HashMap<>();

    public void adicionar(T produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    public Optional<T> buscar(String codigo) {
        return Optional.ofNullable(produtos.get(codigo));
    }

    public boolean remover(String codigo) {
        return produtos.remove(codigo) != null;
    }

    public List<T> listar() {
        return new ArrayList<>(produtos.values());
    }

    public int tamanho() {
        return produtos.size();
    }
    
}