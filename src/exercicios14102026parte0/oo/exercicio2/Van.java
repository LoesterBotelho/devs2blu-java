package exercicios14102026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Van extends Veiculo {

    public Van(String placa) {
        super(placa, 1500.0, new BigDecimal("2.50"));
    }

    @Override
    public String getTipo() {
        return "Van";
    }

    @Override
    public BigDecimal calcularFrete(double distanciaKm) {
        return super.calcularFrete(distanciaKm)
                .add(new BigDecimal("15.00"));
    }
}