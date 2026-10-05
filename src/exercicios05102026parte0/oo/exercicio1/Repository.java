package exercicios05102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    void salvar(T objeto);

    Optional<T> buscar(ID id);

    List<T> listar();

    void remover(ID id);

}