package exercicios04102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

public class CalculadoraDesconto {

    private final Map<TipoCliente, Function<BigDecimal, BigDecimal>>
            descontos = Map.of(

            TipoCliente.COMUM,
            valor -> valor,

            TipoCliente.VIP,
            valor -> valor.multiply(new BigDecimal("0.95")),

            TipoCliente.PREMIUM,
            valor -> valor.multiply(new BigDecimal("0.90"))
    );

    public BigDecimal calcular(
            TipoCliente tipo,
            BigDecimal valor) {

        return descontos
                .get(tipo)
                .apply(valor);
    }
}