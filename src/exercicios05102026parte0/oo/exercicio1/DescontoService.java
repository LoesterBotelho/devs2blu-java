package exercicios05102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

public class DescontoService {

    private final Map<TipoCliente,
            Function<BigDecimal, BigDecimal>> regras;

    public DescontoService() {

        regras = Map.of(
                TipoCliente.COMUM,
                valor -> valor,

                TipoCliente.VIP,
                valor -> valor.multiply(
                        new BigDecimal("0.95")
                ),

                TipoCliente.PREMIUM,
                valor -> valor.multiply(
                        new BigDecimal("0.90")
                )
        );
    }

    public BigDecimal aplicar(
            Cliente cliente,
            BigDecimal valor) {

        return regras
                .get(cliente.tipo())
                .apply(valor);
    }
}