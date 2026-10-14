package exercicios14102026parte0.oo.exercicio2;

import java.math.BigDecimal;

public abstract class Veiculo {
	
    private final String placa;
    private final double capacidadeKg;
    private final BigDecimal custoPorKm;

    protected Veiculo(
            String placa,
            double capacidadeKg,
            BigDecimal custoPorKm) {

        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("Placa obrigatoria");
        }
        if (capacidadeKg <= 0) {
            throw new IllegalArgumentException("Capacidade invalida");
        }
        if (custoPorKm == null
                || custoPorKm.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Custo invalido");
        }

        this.placa = placa;
        this.capacidadeKg = capacidadeKg;
        this.custoPorKm = custoPorKm;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCapacidadeKg() {
        return capacidadeKg;
    }

    public BigDecimal getCustoPorKm() {
        return custoPorKm;
    }

    public boolean suportaPeso(double pesoKg) {
        return pesoKg > 0 && pesoKg <= capacidadeKg;
    }

    public BigDecimal calcularFrete(double distanciaKm) {
        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("Distancia invalida");
        }

        return custoPorKm.multiply(BigDecimal.valueOf(distanciaKm));
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo()
                + " | Placa: " + placa
                + " | Capacidade: " + capacidadeKg + " kg"
                + " | Custo/km: R$ " + custoPorKm;
    }
    
}