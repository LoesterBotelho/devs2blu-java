package exercicios14102026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Caminhao extends Veiculo {

    public Caminhao(String placa) {
        super(placa, 12000.0, new BigDecimal("6.80"));
    }

    @Override
    public String getTipo() {
        return "Caminhao";
    }

    @Override
    public BigDecimal calcularFrete(double distanciaKm) {
        return super.calcularFrete(distanciaKm)
                .add(new BigDecimal("100.00"));
    }
}