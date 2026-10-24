package exercicios24102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T extends Identificavel> {
    void salvar(T entidade);

    Optional<T> buscarPorId(Long id);

    List<T> listarTodos();

    boolean remover(Long id);
}