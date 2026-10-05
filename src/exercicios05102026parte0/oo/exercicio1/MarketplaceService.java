package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
// import java.time.LocalDateTime;

public class MarketplaceService {

    private final EstoqueService estoque;
    private final DescontoService desconto;
    private final FreteService frete;
    private final PagamentoService pagamento;

    public MarketplaceService(
            EstoqueService estoque,
            DescontoService desconto,
            FreteService frete,
            PagamentoService pagamento) {

        this.estoque = estoque;
        this.desconto = desconto;
        this.frete = frete;
        this.pagamento = pagamento;
    }

    public Pagamento finalizarPedido(
            Pedido pedido,
            FormaPagamento formaPagamento,
            Long pagamentoId) {

        pedido.getItens()
                .forEach(item -> {

                    if (!estoque.possui(
                            item.produto(),
                            item.quantidade())) {

                        throw new IllegalStateException(
                                "Estoque insuficiente: "
                                        + item.produto()
                                                .getNome()
                        );
                    }
                });

        pedido.getItens()
                .forEach(item ->
                        estoque.retirar(
                                item.produto(),
                                item.quantidade()
                        ));

        BigDecimal subtotal =
                pedido.subtotal();

        BigDecimal valorDesconto =
                desconto.aplicar(
                        pedido.getCliente(),
                        subtotal
                );

        BigDecimal valorFrete =
                frete.calcular(pedido);

        BigDecimal total =
                valorDesconto.add(valorFrete);

        Pagamento pagamentoProcessado =
                pagamento.processar(
                        pagamentoId,
                        pedido,
                        formaPagamento,
                        total
                );

        pedido.alterarStatus(
                StatusPedido.PAGO
        );

        return pagamentoProcessado;
    }
}