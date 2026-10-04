package exercicios04102026parte0.oo.exercicio1;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private Map<Long, Integer> produtos = new HashMap<>();

    public void adicionar(Long produtoId, int quantidade) {

        produtos.merge(
                produtoId,
                quantidade,
                Integer::sum
        );
    }

    public boolean possui(Long produtoId, int quantidade) {

        return produtos.getOrDefault(produtoId, 0) >= quantidade;
    }

    public void remover(Long produtoId, int quantidade) {

        produtos.computeIfPresent(
                produtoId,
                (id, atual) -> atual - quantidade
        );
    }

    public int quantidade(Long produtoId) {

        return produtos.getOrDefault(produtoId, 0);
    }
}