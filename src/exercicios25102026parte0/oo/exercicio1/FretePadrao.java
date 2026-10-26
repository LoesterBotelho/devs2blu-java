package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class FretePadrao implements CalculadoraFrete {
	
    private static final BigDecimal TAXA_FIXA = new BigDecimal("8.00");
    private static final BigDecimal VALOR_POR_KG = new BigDecimal("1.20");
    private static final BigDecimal VALOR_POR_KM = new BigDecimal("0.15");

    @Override
    public BigDecimal calcular(Pacote pacote, BigDecimal distanciaKm) {
        validar(pacote, distanciaKm);

        return TAXA_FIXA
                .add(pacote.pesoKg().multiply(VALOR_POR_KG))
                .add(distanciaKm.multiply(VALOR_POR_KM))
                .setScale(2, java.math.RoundingMode.HALF_UP);
    }

    private void validar(Pacote pacote, BigDecimal distanciaKm) {
        if (pacote == null
                || distanciaKm == null
                || distanciaKm.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Dados do frete inválidos");
        }
    }
    
}