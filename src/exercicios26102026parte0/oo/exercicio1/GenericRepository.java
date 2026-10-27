package exercicios26102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.ToLongFunction;

public class GenericRepository<T> implements Repository<T> {
	
    private final Map<Long, T> entities = new LinkedHashMap<>();
    private final ToLongFunction<T> idExtractor;

    public GenericRepository(ToLongFunction<T> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public T save(T entity) {
        entities.put(idExtractor.applyAsLong(entity), entity);
        return entity;
    }

    @Override
    public Optional<T> findById(long id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public boolean deleteById(long id) {
        return entities.remove(id) != null;
    }
    
}