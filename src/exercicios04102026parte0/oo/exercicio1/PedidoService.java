package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class PedidoService {

    private final CalculadoraDesconto desconto;
    private final CalculadoraFrete frete;

    public PedidoService(
            CalculadoraDesconto desconto,
            CalculadoraFrete frete) {

        this.desconto = desconto;
        this.frete = frete;
    }

    public BigDecimal calcularTotal(Pedido pedido) {

        BigDecimal subtotal = pedido.subtotal();

        BigDecimal valorComDesconto =
                desconto.calcular(
                        pedido.getCliente().tipo(),
                        subtotal
                );

        return valorComDesconto
                .add(frete.calcular(pedido));
    }

    public List<Pedido> pedidosAcima(
            List<Pedido> pedidos,
            BigDecimal valor) {

        return pedidos.stream()
                .filter(pedido ->
                        calcularTotal(pedido)
                                .compareTo(valor) > 0)
                .toList();
    }
}