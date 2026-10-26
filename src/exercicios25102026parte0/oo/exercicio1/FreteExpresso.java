package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FreteExpresso implements CalculadoraFrete {
	
    private final CalculadoraFrete fretePadrao;

    public FreteExpresso(CalculadoraFrete fretePadrao) {
        if (fretePadrao == null) {
            throw new IllegalArgumentException(
                    "Calculadora de frete obrigatória");
        }

        this.fretePadrao = fretePadrao;
    }

    @Override
    public BigDecimal calcular(Pacote pacote, BigDecimal distanciaKm) {
        return fretePadrao.calcular(pacote, distanciaKm)
                .multiply(new BigDecimal("1.50"))
                .setScale(2, RoundingMode.HALF_UP);
    }
    
}