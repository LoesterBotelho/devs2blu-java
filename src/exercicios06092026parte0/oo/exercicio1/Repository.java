package exercicios06092026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

interface Repository<T extends Identifiable<ID>, ID> {
	
	void save(T entity);

	Optional<T> findById(ID id);

	List<T> findBy(Predicate<T> criteria);
	
}