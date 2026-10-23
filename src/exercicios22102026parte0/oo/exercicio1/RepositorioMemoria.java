package exercicios22102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public class RepositorioMemoria<T extends Identificavel>
        implements Repositorio<T> {

    private final Map<Long, T> dados = new LinkedHashMap<>();

    @Override
    public void adicionar(T objeto) {
        dados.put(objeto.getId(), objeto);
    }

    @Override
    public Optional<T> buscarPorId(Long id) {
        return Optional.ofNullable(dados.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(dados.values());
    }

    @Override
    public boolean remover(Long id) {
        return dados.remove(id) != null;
    }

    @Override
    public int tamanho() {
        return dados.size();
    }
}