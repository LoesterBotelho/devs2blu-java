package exercicios05102026parte0.oo.exercicio1;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    public static <T> List<T> filtrar(
            Collection<T> dados,
            Predicate<T> predicate) {

        return dados.stream()
                .filter(predicate)
                .toList();
    }

    public static <T, R> List<R> transformar(
            Collection<T> dados,
            Function<T, R> function) {

        return dados.stream()
                .map(function)
                .toList();
    }

    public static <T> List<T> ordenar(
            Collection<T> dados,
            Comparator<T> comparator) {

        return dados.stream()
                .sorted(comparator)
                .toList();
    }

    public static <T, R extends Comparable<R>>
    T maiorPor(
            Collection<T> dados,
            Function<T, R> function) {

        return dados.stream()
                .max(
                        Comparator.comparing(function)
                )
                .orElseThrow();
    }
}