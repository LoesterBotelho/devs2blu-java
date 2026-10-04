package exercicios03102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoService {

    private RepositorioProduto repositorio;

    public ProdutoService(RepositorioProduto repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> buscarPorCategoria(Categoria categoria) {

        return repositorio.listar()
                .stream()
                .filter(produto -> produto.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    public List<Produto> buscarPorPreco(BigDecimal preco) {

        return repositorio.listar()
                .stream()
                .filter(produto -> produto.getPreco().compareTo(preco) > 0)
                .collect(Collectors.toList());
    }

    public BigDecimal calcularTotal() {

        return repositorio.listar()
                .stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}