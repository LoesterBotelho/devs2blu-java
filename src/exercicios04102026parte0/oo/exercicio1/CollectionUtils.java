package exercicios04102026parte0.oo.exercicio1;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static <T, R> List<R> map(
            Collection<T> collection,
            Function<T, R> function) {

        return collection.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    public static <T> List<T> ordenar(
            Collection<T> collection,
            Comparator<T> comparator) {

        return collection.stream()
                .sorted(comparator)
                .toList();
    }

    public static <T> boolean todos(
            Collection<T> collection,
            java.util.function.Predicate<T> predicate) {

        return collection.stream()
                .allMatch(predicate);
    }
}