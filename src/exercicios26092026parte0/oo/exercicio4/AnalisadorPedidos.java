package exercicios26092026parte0.oo.exercicio4;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnalisadorPedidos {

    public static BigDecimal calcularFaturamentoFiltrado(
            List<Pedido> pedidos,
            Predicate<? super Pedido> criterio) {

        return pedidos.stream()
                .filter(criterio)
                .map(Pedido::getValorTotalPedido)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public static Map<String, BigDecimal> faturamentoPorCategoriaAprovados(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .filter(pedido ->
                        pedido.getStatus() == StatusPedido.APROVADO
                )
                .flatMap(pedido ->
                        pedido.getItens().stream()
                )
                .collect(
                        Collectors.groupingBy(
                                ItemPedido::getCategoria,
                                Collectors.mapping(
                                        ItemPedido::getValorTotalItem,
                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public static List<ItemPedido> todosOsItens(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .flatMap(pedido ->
                        pedido.getItens().stream()
                )
                .toList();
    }

    public static ItemPedido produtoMaisCaro(
            List<Pedido> pedidos) {

        return todosOsItens(pedidos)
                .stream()
                .max(
                        Comparator.comparing(
                                ItemPedido::getValorTotalItem
                        )
                )
                .orElseThrow();
    }

    public static List<Pedido> ordenarPorValorDescendente(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .sorted(
                        Comparator.comparing(
                                Pedido::getValorTotalPedido
                        ).reversed()
                )
                .toList();
    }

    public static <T> void processarEImprimir(
            List<T> elementos,
            Consumer<? super T> acao) {

        elementos.forEach(acao);
    }

    public static <T, R> List<R> transformar(
            List<T> elementos,
            Function<T, R> funcao) {

        return elementos.stream()
                .map(funcao)
                .toList();
    }

    public static <T extends Pedido> BigDecimal calcularTotal(
            List<T> pedidos) {

        return pedidos.stream()
                .map(Pedido::getValorTotalPedido)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }
}