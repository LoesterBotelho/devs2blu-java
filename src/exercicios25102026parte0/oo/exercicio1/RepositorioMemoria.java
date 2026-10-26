package exercicios25102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RepositorioMemoria<T extends Identificavel>
        implements Repositorio<T> {

    private final Map<String, T> entidades = new LinkedHashMap<>();

    @Override
    public void salvar(T entidade) {
        if (entidade == null
                || entidade.getId() == null
                || entidade.getId().isBlank()) {
            throw new IllegalArgumentException("Entidade ou ID inválido");
        }

        entidades.put(entidade.getId(), entidade);
    }

    @Override
    public Optional<T> buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            return Optional.empty();
        }

        return Optional.ofNullable(entidades.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(entidades.values());
    }

    @Override
    public boolean remover(String id) {
        if (id == null || id.isBlank()) {
            return false;
        }

        return entidades.remove(id) != null;
    }

    @Override
    public long contar() {
        return entidades.size();
    }
    
}