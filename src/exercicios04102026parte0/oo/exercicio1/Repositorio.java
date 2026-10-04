package exercicios04102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T, ID> {

    void salvar(T objeto);

    void remover(ID id);

    Optional<T> buscar(ID id);

    List<T> listar();

}