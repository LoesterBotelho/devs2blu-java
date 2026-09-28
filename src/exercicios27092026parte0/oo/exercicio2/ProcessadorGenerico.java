package exercicios27092026parte0.oo.exercicio2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public final class ProcessadorGenerico {

    private ProcessadorGenerico() {
    }

    public static <T> List<T> filtrar(
            List<T> elementos,
            Predicate<T> criterio) {

        return elementos.stream()
                .filter(criterio)
                .toList();
    }

    public static <T, R> List<R> transformar(
            List<T> elementos,
            Function<T, R> funcao) {

        return elementos.stream()
                .map(funcao)
                .toList();
    }

    public static <T> void consumir(
            List<T> elementos,
            Consumer<T> consumidor) {

        elementos.forEach(consumidor);
    }

    public static <T> void copiar(
            List<? extends T> origem,
            List<? super T> destino) {

        destino.addAll(origem);
    }
}