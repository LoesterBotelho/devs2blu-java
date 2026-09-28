package exercicios28092026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Estoque {

    private final Map<Long, Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public void adicionar(Produto produto) {
        produtos.put(
                produto.getId(),
                produto
        );
    }

    public Optional<Produto> buscar(Long id) {
        return Optional.ofNullable(
                produtos.get(id)
        );
    }

    public Optional<Produto> remover(Long id) {
        return Optional.ofNullable(
                produtos.remove(id)
        );
    }

    public List<Produto> listar() {
        return new ArrayList<>(
                produtos.values()
        );
    }

    public List<Produto> listarPorCategoria(
            CategoriaProduto categoria) {

        return produtos.values()
                .stream()
                .filter(produto ->
                        produto.getCategoria() == categoria
                )
                .toList();
    }

    public List<Produto> listarEstoqueBaixo(
            int limite) {

        return produtos.values()
                .stream()
                .filter(produto ->
                        produto.getQuantidade() <= limite
                )
                .toList();
    }

    public Optional<Produto> produtoMaisCaro() {
        return produtos.values()
                .stream()
                .max(
                        Comparator.comparing(
                                Produto::getPreco
                        )
                );
    }

    public Optional<Produto> produtoMaisBarato() {
        return produtos.values()
                .stream()
                .min(
                        Comparator.comparing(
                                Produto::getPreco
                        )
                );
    }

    public List<Produto> ordenarPorPreco() {
        return produtos.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Produto::getPreco
                        )
                )
                .toList();
    }

    public List<Produto> ordenarPorPrecoDescendente() {
        return produtos.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Produto::getPreco
                        ).reversed()
                )
                .toList();
    }

    public BigDecimal calcularValorTotal() {
        return produtos.values()
                .stream()
                .map(Produto::getValorTotalEstoque)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public Map<CategoriaProduto, List<Produto>>
    agruparPorCategoria() {

        return produtos.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Produto::getCategoria
                        )
                );
    }

    public Set<Long> listarIds() {
        return produtos.keySet();
    }

    public int quantidadeProdutos() {
        return produtos.size();
    }
}