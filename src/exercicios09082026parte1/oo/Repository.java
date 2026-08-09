package exercicios09082026parte1.oo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Repository<T> {

	private final List<T> items = new ArrayList<>();

	public Repository() {
	}

	public void save(T item) {
		items.add(item);
	}

	public void saveAll(Collection<T> items) {
		this.items.addAll(items);
	}

	public T findFirst() {

		if (items.isEmpty()) {
			return null;
		}

		return items.getFirst();
	}

	public List<T> findAll() {
		return List.copyOf(items);
	}

	public int count() {
		return items.size();
	}

	@Override
    public String toString() {
        return "Repository{" +
                "items=" + items +
                '}';
    }
}
