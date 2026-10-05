package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Function;

public class PagamentoService {

    private final Map<FormaPagamento,
            Function<BigDecimal, BigDecimal>> taxas;

    public PagamentoService() {

        taxas = Map.of(
                FormaPagamento.PIX,
                valor -> valor,

                FormaPagamento.CARTAO_DEBITO,
                valor -> valor.multiply(
                        new BigDecimal("1.01")
                ),

                FormaPagamento.CARTAO_CREDITO,
                valor -> valor.multiply(
                        new BigDecimal("1.05")
                ),

                FormaPagamento.BOLETO,
                valor -> valor
        );
    }

    public Pagamento processar(
            Long id,
            Pedido pedido,
            FormaPagamento forma,
            BigDecimal valor) {

        BigDecimal valorFinal =
                taxas.get(forma)
                        .apply(valor);

        return new Pagamento(
                id,
                pedido,
                valorFinal,
                forma,
                StatusPagamento.APROVADO,
                LocalDateTime.now()
        );
    }
}