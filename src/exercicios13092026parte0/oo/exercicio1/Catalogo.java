package exercicios13092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Catalogo<T extends Precificavel> {

    private final List<T> produtos = new ArrayList<>();

    public void adicionar(T produto) {
        produtos.add(produto);
    }

    public List<T> listar() {
        return List.copyOf(produtos);
    }

    public Optional<T> buscarMaisCaro() {
        return produtos.stream()
                .max(Comparator.comparingDouble(Precificavel::getPreco));
    }

    public List<T> filtrar(Predicate<T> criterio) {
        return produtos.stream()
                .filter(criterio)
                .toList();
    }

    public <R> List<R> mapear(Function<T, R> mapper) {
        return produtos.stream()
                .map(mapper)
                .toList();
    }

}