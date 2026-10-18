package exercicios18102026parte0.oo.exercicio2;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    void save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    boolean deleteById(ID id);
}