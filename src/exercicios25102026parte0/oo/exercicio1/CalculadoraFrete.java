package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculadoraFrete {
    BigDecimal calcular(Pacote pacote, BigDecimal distanciaKm);
}