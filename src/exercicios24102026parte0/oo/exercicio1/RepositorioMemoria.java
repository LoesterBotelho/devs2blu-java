package exercicios24102026parte0.oo.exercicio1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RepositorioMemoria<T extends Identificavel>
        implements Repositorio<T> {

    private final Map<Long, T> dados = new LinkedHashMap<>();

    @Override
    public void salvar(T entidade) {
        if (entidade == null) {
            throw new IllegalArgumentException("Entidade obrigatória");
        }

        dados.put(entidade.getId(), entidade);
    }

    @Override
    public Optional<T> buscarPorId(Long id) {
        return Optional.ofNullable(dados.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return List.copyOf(dados.values());
    }

    @Override
    public boolean remover(Long id) {
        return dados.remove(id) != null;
    }
    
}