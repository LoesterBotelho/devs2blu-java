package exercicios28092026parte0.oo.exercicio5;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Pipeline<T> {

    private final List<T> elementos;

    private Pipeline(List<T> elementos) {
        this.elementos = List.copyOf(elementos);
    }

    public static <T> Pipeline<T> criar(List<T> elementos) {
        return new Pipeline<>(elementos);
    }

    public Pipeline<T> filtrar(Predicate<T> criterio) {
        return new Pipeline<>(
                elementos.stream()
                        .filter(criterio)
                        .toList()
        );
    }

    public Pipeline<T> ordenar(Comparator<T> comparador) {
        return new Pipeline<>(
                elementos.stream()
                        .sorted(comparador)
                        .toList()
        );
    }

    public <R> Pipeline<R> mapear(Function<T, R> funcao) {
        return new Pipeline<>(
                elementos.stream()
                        .map(funcao)
                        .toList()
        );
    }

    public <R> Pipeline<R> flatMapear(Function<T, List<R>> funcao) {
        return new Pipeline<>(
                elementos.stream()
                        .flatMap(elemento -> funcao.apply(elemento).stream())
                        .toList()
        );
    }

    public Pipeline<T> limitar(int quantidade) {
        return new Pipeline<>(
                elementos.stream()
                        .limit(quantidade)
                        .toList()
        );
    }

    public Pipeline<T> pular(int quantidade) {
        return new Pipeline<>(
                elementos.stream()
                        .skip(quantidade)
                        .toList()
        );
    }

    public Pipeline<T> distinct() {
        return new Pipeline<>(
                elementos.stream()
                        .distinct()
                        .toList()
        );
    }

    public Optional<T> primeiro() {
        return elementos.stream()
                .findFirst();
    }

    public Optional<T> maior(Comparator<T> comparador) {
        return elementos.stream()
                .max(comparador);
    }

    public Optional<T> menor(Comparator<T> comparador) {
        return elementos.stream()
                .min(comparador);
    }

    public long contar() {
        return elementos.size();
    }

    public List<T> listar() {
        return List.copyOf(elementos);
    }

    public void consumir(Consumer<T> consumidor) {
        elementos.forEach(consumidor);
    }

    public BigDecimal somar(Function<T, BigDecimal> funcao) {
        return elementos.stream()
                .map(funcao)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public <K> Map<K, List<T>> agruparPor(Function<T, K> funcao) {
        return elementos.stream()
                .collect(Collectors.groupingBy(funcao));
    }
}