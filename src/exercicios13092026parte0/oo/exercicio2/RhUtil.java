package exercicios13092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class RhUtil {

    public static <T> List<T> filtrar(
            List<? extends T> origem,
            Predicate<? super T> criterio) {

        List<T> resultado = new ArrayList<>();

        for (T item : origem) {
            if (criterio.test(item)) {
                resultado.add(item);
            }
        }

        return resultado;
    }

    public static <T, R> List<R> mapear(
            List<? extends T> origem,
            Function<? super T, ? extends R> mapper) {

        List<R> resultado = new ArrayList<>();

        for (T item : origem) {
            resultado.add(mapper.apply(item));
        }

        return resultado;
    }

    public static <T> void adicionarTodos(
            List<? super T> destino,
            List<? extends T> origem) {

        destino.addAll(origem);
    }

}