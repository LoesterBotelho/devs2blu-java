package exercicios04102026parte0.oo.exercicio2;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    void salvar(T objeto);

    Optional<T> buscar(ID id);

    List<T> listar();

}