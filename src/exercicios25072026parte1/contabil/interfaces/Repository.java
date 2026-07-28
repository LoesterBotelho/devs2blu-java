package exercicios25072026parte1.contabil.interfaces;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    void salvar(T entidade);

    void remover(ID id);

    Optional<T> buscar(ID id);

    List<T> listar();

    boolean existe(ID id);

    long quantidade();

}