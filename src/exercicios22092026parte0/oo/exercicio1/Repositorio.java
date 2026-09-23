package exercicios22092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repositorio<T> {

    private List<T> itens = new ArrayList<>();

    public void adicionar(T item) {
        itens.add(item);
    }

    public List<T> listarTodos() {
        return new ArrayList<>(itens);
    }

    public List<T> filtrar(Predicate<T> criterio) {
        return itens.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }
}