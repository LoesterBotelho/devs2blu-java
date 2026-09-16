package exercicios15092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RepositorioEmMemoria<T extends Identifiable<ID>, ID>
        implements Repositorio<T, ID> {

    private final Map<ID, T> armazenamento =
            new HashMap<>();

    @Override
    public void salvar(T item) {
        armazenamento.put(
                item.getId(),
                item
        );
    }

    @Override
    public Optional<T> buscarPorId(ID id) {

        return Optional.ofNullable(
                armazenamento.get(id)
        );
    }

    @Override
    public List<T> listar() {

        return new ArrayList<>(
                armazenamento.values()
        );
    }

}