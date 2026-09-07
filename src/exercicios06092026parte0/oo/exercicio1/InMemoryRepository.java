package exercicios06092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

class InMemoryRepository<T extends Identifiable<ID>, ID> implements Repository<T, ID> {
	
	private final List<T> storage = new ArrayList<>();

	@Override
	public void save(T entity) {
		storage.removeIf(e -> e.id().equals(entity.id()));
		storage.add(entity);
	}

	@Override
	public Optional<T> findById(ID id) {
		return storage.stream().filter(e -> e.id().equals(id)).findFirst();
	}

	@Override
	public List<T> findBy(Predicate<T> criteria) {
		return storage.stream().filter(criteria).toList();
	}
	
}