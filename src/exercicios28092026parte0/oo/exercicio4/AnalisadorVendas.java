package exercicios28092026parte0.oo.exercicio4;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class AnalisadorVendas {

    private AnalisadorVendas() {
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

    public static BigDecimal faturamentoTotal(
            List<Venda> vendas) {

        return vendas.stream()
                .map(Venda::getValorLiquido)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public static Optional<Venda> maiorVenda(
            List<Venda> vendas) {

        return vendas.stream()
                .max(
                        Comparator.comparing(
                                Venda::getValorLiquido
                        )
                );
    }

    public static Optional<Venda> menorVenda(
            List<Venda> vendas) {

        return vendas.stream()
                .min(
                        Comparator.comparing(
                                Venda::getValorLiquido
                        )
                );
    }

    public static List<Venda> ordenarPorValorDescendente(
            List<Venda> vendas) {

        return vendas.stream()
                .sorted(
                        Comparator.comparing(
                                Venda::getValorLiquido
                        ).reversed()
                )
                .toList();
    }

    public static Map<Vendedor, BigDecimal>
    faturamentoPorVendedor(
            List<Venda> vendas) {

        return vendas.stream()
                .collect(
                        Collectors.groupingBy(
                                Venda::getVendedor,
                                Collectors.mapping(
                                        Venda::getValorLiquido,
                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public static Map<Regiao, BigDecimal>
    faturamentoPorRegiao(
            List<Venda> vendas) {

        return vendas.stream()
                .collect(
                        Collectors.groupingBy(
                                venda ->
                                        venda.getVendedor()
                                                .getRegiao(),
                                Collectors.mapping(
                                        Venda::getValorLiquido,
                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public static Map<String, BigDecimal>
    faturamentoPorCategoria(
            List<Venda> vendas) {

        return vendas.stream()
                .collect(
                        Collectors.groupingBy(
                                venda ->
                                        venda.getProduto()
                                                .getCategoria(),
                                Collectors.mapping(
                                        Venda::getValorLiquido,
                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public static Map<String, Long>
    quantidadePorProduto(
            List<Venda> vendas) {

        return vendas.stream()
                .collect(
                        Collectors.groupingBy(
                                venda ->
                                        venda.getProduto()
                                                .getNome(),
                                Collectors.summingLong(
                                        Venda::getQuantidade
                                )
                        )
                );
    }

    public static Set<String> produtosVendidos(
            List<Venda> vendas) {

        return vendas.stream()
                .map(
                        venda ->
                                venda.getProduto()
                                        .getNome()
                )
                .collect(
                        Collectors.toSet()
                );
    }
}