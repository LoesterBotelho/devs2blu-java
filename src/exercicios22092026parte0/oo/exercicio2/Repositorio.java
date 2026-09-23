package exercicios22092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
                .toList();
    }
}