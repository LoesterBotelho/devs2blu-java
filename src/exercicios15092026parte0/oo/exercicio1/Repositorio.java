package exercicios15092026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T extends Identifiable<ID>, ID> {

    void salvar(T item);

    Optional<T> buscarPorId(ID id);

    List<T> listar();

}