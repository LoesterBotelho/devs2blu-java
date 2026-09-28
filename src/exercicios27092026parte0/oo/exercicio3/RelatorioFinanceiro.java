package exercicios27092026parte0.oo.exercicio3;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class RelatorioFinanceiro {

    private RelatorioFinanceiro() {
    }

    public static BigDecimal somar(
            List<Transacao> transacoes,
            Predicate<? super Transacao> criterio) {

        return transacoes.stream()
                .filter(criterio)
                .map(Transacao::getValor)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public static Map<TipoTransacao, BigDecimal> totalPorTipo(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(
                        Collectors.groupingBy(
                                Transacao::getTipo,
                                Collectors.mapping(
                                        Transacao::getValor,
                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public static Map<String, BigDecimal> totalPorCliente(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(
                        Collectors.groupingBy(
                                Transacao::getCliente,
                                Collectors.mapping(
                                        Transacao::getValor,
                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public static Map<StatusTransacao, Long> quantidadePorStatus(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(
                        Collectors.groupingBy(
                                Transacao::getStatus,
                                Collectors.counting()
                        )
                );
    }

    public static Map<Boolean, List<Transacao>> particionarPorValor(
            List<Transacao> transacoes,
            BigDecimal limite) {

        return transacoes.stream()
                .collect(
                        Collectors.partitioningBy(
                                transacao ->
                                        transacao.getValor()
                                                .compareTo(limite) > 0
                        )
                );
    }

    public static Optional<Transacao> maiorTransacao(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .max(
                        Comparator.comparing(
                                Transacao::getValor
                        )
                );
    }

    public static Optional<Transacao> menorTransacao(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .min(
                        Comparator.comparing(
                                Transacao::getValor
                        )
                );
    }

    public static List<Transacao> ordenarPorValorDescendente(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .sorted(
                        Comparator.comparing(
                                Transacao::getValor
                        ).reversed()
                )
                .toList();
    }

    public static List<String> extrairClientes(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .map(Transacao::getCliente)
                .distinct()
                .sorted()
                .toList();
    }

    public static List<Transacao> filtrar(
            List<Transacao> transacoes,
            Predicate<? super Transacao> criterio) {

        return transacoes.stream()
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

    public static <T> void processar(
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