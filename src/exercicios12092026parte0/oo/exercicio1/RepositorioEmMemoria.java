package exercicios12092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class RepositorioEmMemoria<T extends Identifiable<ID>, ID> implements Repositorio<T, ID> {

    private final Map<ID, T> armazenamento = new HashMap<>();

    @Override
    public void salvar(T item) {
        armazenamento.put(item.getId(), item);
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(armazenamento.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(armazenamento.values());
    }

    @Override
    public <R> List<R> transformar(Function<T, R> mapper) {
        List<R> resultado = new ArrayList<>();

        for (T item : armazenamento.values()) {
            resultado.add(mapper.apply(item));
        }

        return resultado;
    }

}