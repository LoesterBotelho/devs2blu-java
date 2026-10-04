package exercicios04102026parte0.oo.exercicio2;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    public static <T> List<T> filtrar(
            Collection<T> collection,
            Predicate<T> predicate) {

        return collection.stream()
                .filter(predicate)
                .toList();
    }

    public static <T, R> List<R> transformar(
            Collection<T> collection,
            Function<T, R> function) {

        return collection.stream()
                .map(function)
                .toList();
    }

    public static <T> boolean existe(
            Collection<T> collection,
            Predicate<T> predicate) {

        return collection.stream()
                .anyMatch(predicate);
    }
}