package exercicios27092026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnalisadorPedidos {

    public static List<Pedido> filtrar(
            List<Pedido> pedidos,
            Predicate<? super Pedido> criterio) {

        return pedidos.stream()
                .filter(criterio)
                .toList();
    }

    public static BigDecimal calcularFaturamento(
            List<Pedido> pedidos,
            Predicate<? super Pedido> criterio) {

        return pedidos.stream()
                .filter(criterio)
                .map(Pedido::getValorTotal)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public static Map<String, BigDecimal> faturamentoPorCidade(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .filter(pedido ->
                        pedido.getStatus() == StatusPedido.APROVADO
                )
                .collect(
                        Collectors.groupingBy(
                                pedido ->
                                        pedido.getCliente().getCidade(),
                                Collectors.mapping(
                                        Pedido::getValorTotal,
                                        Collectors.reducing(
                                                BigDecimal.ZERO,
                                                BigDecimal::add
                                        )
                                )
                        )
                );
    }

    public static Map<String, Long> quantidadePedidosPorCidade(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .collect(
                        Collectors.groupingBy(
                                pedido ->
                                        pedido.getCliente().getCidade(),
                                Collectors.counting()
                        )
                );
    }

    public static Map<StatusPedido, List<Pedido>> agruparPorStatus(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .collect(
                        Collectors.groupingBy(
                                Pedido::getStatus
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

    public static List<Produto> produtosVendidos(
            List<Pedido> pedidos) {

        return todosOsItens(pedidos)
                .stream()
                .map(ItemPedido::getProduto)
                .toList();
    }

    public static Produto produtoMaisCaro(
            List<Pedido> pedidos) {

        return produtosVendidos(pedidos)
                .stream()
                .max(
                        Comparator.comparing(
                                Produto::getPreco
                        )
                )
                .orElseThrow();
    }

    public static List<Pedido> ordenarPorValor(
            List<Pedido> pedidos) {

        return pedidos.stream()
                .sorted(
                        Comparator.comparing(
                                Pedido::getValorTotal
                        ).reversed()
                )
                .toList();
    }

    public static <T> void processar(
            List<T> elementos,
            Consumer<? super T> consumidor) {

        elementos.forEach(consumidor);
    }

    public static <T, R> List<R> transformar(
            List<T> elementos,
            Function<T, R> funcao) {

        return elementos.stream()
                .map(funcao)
                .toList();
    }
}