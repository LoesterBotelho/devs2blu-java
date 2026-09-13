package exercicios12092026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface Repositorio<T, ID> {

	void salvar(T item);

	Optional<T> buscarPorId(ID id);

	List<T> listarTodos();

	<R> List<R> transformar(Function<T, R> mapper);
}