package exercicios28092026parte0.oo.exercicio3;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ProcessadorPagamentos {

    private ProcessadorPagamentos() {
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

    public static <T> Optional<T> maior(
            List<T> elementos,
            Comparator<T> comparador) {

        return elementos.stream()
                .max(comparador);
    }

    public static <T> Optional<T> menor(
            List<T> elementos,
            Comparator<T> comparador) {

        return elementos.stream()
                .min(comparador);
    }

    public static <T> BigDecimal somar(
            List<T> elementos,
            Function<T, BigDecimal> extrator) {

        return elementos.stream()
                .map(extrator)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public static <T> List<BigDecimal> calcular(
            List<T> elementos,
            Function<T, BigDecimal> funcao) {

        return elementos.stream()
                .map(funcao)
                .toList();
    }

    public static <T> BigDecimal aplicarRegra(
            T elemento,
            RegraPagamento<T> regra) {

        return regra.aplicar(elemento);
    }

    public static <T> List<BigDecimal> aplicarRegra(
            List<T> elementos,
            RegraPagamento<T> regra) {

        return elementos.stream()
                .map(regra::aplicar)
                .toList();
    }

    public static Map<TipoPagamento, List<Pagamento>>
    agruparPorTipo(
            List<Pagamento> pagamentos) {

        return pagamentos.stream()
                .collect(
                        Collectors.groupingBy(
                                Pagamento::getTipo
                        )
                );
    }

    public static Map<StatusPagamento, List<Pagamento>>
    agruparPorStatus(
            List<Pagamento> pagamentos) {

        return pagamentos.stream()
                .collect(
                        Collectors.groupingBy(
                                Pagamento::getStatus
                        )
                );
    }

    public static Map<Boolean, List<Pagamento>>
    particionarPorValor(
            List<Pagamento> pagamentos,
            BigDecimal limite) {

        return pagamentos.stream()
                .collect(
                        Collectors.partitioningBy(
                                pagamento ->
                                        pagamento.getValor()
                                                .compareTo(limite) > 0
                        )
                );
    }
}