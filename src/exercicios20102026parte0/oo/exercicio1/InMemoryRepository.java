package exercicios20102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.ToLongFunction;

public class InMemoryRepository<T> implements Repository<T> {
    private final Map<Long, T> storage = new LinkedHashMap<>();
    private final ToLongFunction<T> idExtractor;

    public InMemoryRepository(ToLongFunction<T> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public T save(T entity) {
        storage.put(idExtractor.applyAsLong(entity), entity);
        return entity;
    }

    @Override
    public Optional<T> findById(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public boolean deleteById(long id) {
        return storage.remove(id) != null;
    }
}
