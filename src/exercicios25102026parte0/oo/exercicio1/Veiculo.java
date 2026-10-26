package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public abstract class Veiculo implements Identificavel {
	
    private final String id;
    private final String placa;
    private final BigDecimal capacidadeKg;

    protected Veiculo(String id, String placa, BigDecimal capacidadeKg) {
        if (id == null || id.isBlank()
                || placa == null || placa.isBlank()
                || capacidadeKg == null
                || capacidadeKg.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Dados do veículo inválidos");
        }

        this.id = id;
        this.placa = placa;
        this.capacidadeKg = capacidadeKg;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public BigDecimal getCapacidadeKg() {
        return capacidadeKg;
    }

    public abstract BigDecimal calcularCustoOperacional(BigDecimal distanciaKm);

    public abstract String getTipo();
    
}