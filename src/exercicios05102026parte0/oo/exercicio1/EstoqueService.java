package exercicios05102026parte0.oo.exercicio1;

import java.util.HashMap;
import java.util.Map;

public class EstoqueService {

    private final Map<Long, Integer> estoque =
            new HashMap<>();

    public void adicionar(
            Produto produto,
            int quantidade) {

        estoque.merge(
                produto.getId(),
                quantidade,
                Integer::sum
        );
    }

    public boolean possui(
            Produto produto,
            int quantidade) {

        return estoque.getOrDefault(
                produto.getId(),
                0
        ) >= quantidade;
    }

    public void retirar(
            Produto produto,
            int quantidade) {

        if (!possui(produto, quantidade)) {
            throw new IllegalStateException(
                    "Estoque insuficiente"
            );
        }

        estoque.computeIfPresent(
                produto.getId(),
                (id, atual) ->
                        atual - quantidade
        );
    }

    public int quantidade(Produto produto) {

        return estoque.getOrDefault(
                produto.getId(),
                0
        );
    }
}