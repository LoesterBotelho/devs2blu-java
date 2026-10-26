package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class Van extends Veiculo {
	
    public Van(String id, String placa, BigDecimal capacidadeKg) {
        super(id, placa, capacidadeKg);
    }

    @Override
    public BigDecimal calcularCustoOperacional(BigDecimal distanciaKm) {
        if (distanciaKm == null || distanciaKm.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Distância inválida");
        }

        return distanciaKm.multiply(new BigDecimal("0.80"));
    }

    @Override
    public String getTipo() {
        return "Van";
    }
    
}