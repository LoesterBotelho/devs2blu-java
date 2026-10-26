package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public record Pacote(
        BigDecimal pesoKg,
        BigDecimal comprimentoCm,
        BigDecimal larguraCm,
        BigDecimal alturaCm) {

    public Pacote {
        if (!positivo(pesoKg)
                || !positivo(comprimentoCm)
                || !positivo(larguraCm)
                || !positivo(alturaCm)) {
            throw new IllegalArgumentException(
                    "Peso e dimensões devem ser positivos");
        }
    }

    public BigDecimal calcularVolumeCm3() {
        return comprimentoCm
                .multiply(larguraCm)
                .multiply(alturaCm);
    }

    private static boolean positivo(BigDecimal valor) {
        return valor != null
                && valor.compareTo(BigDecimal.ZERO) > 0;
    }
}