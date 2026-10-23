package exercicios22102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T extends Identificavel> {

    void adicionar(T objeto);

    Optional<T> buscarPorId(Long id);

    List<T> listarTodos();

    boolean remover(Long id);

    int tamanho();
}