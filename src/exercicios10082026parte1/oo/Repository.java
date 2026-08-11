package exercicios10082026parte1.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository<T extends Identifiable<Long>> {

    private final List<T> items = new ArrayList<>();

    public void save(T item) {
        items.add(item);
    }

    public Optional<T> findById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    public void delete(T item) {
        items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public void addAll(List<? extends T> newItems) {
        items.addAll(newItems);
    }

    public void copyTo(List<? super T> destination) {
        destination.addAll(items);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "items=" + items +
                '}';
    }
}