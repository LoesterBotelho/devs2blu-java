package exercicios15082026parte0.oo.exercicio1;

import java.util.Objects;

public abstract class Veiculo {
	private static int contadorId = 1;
	private final int id;
	private String placa;
	private String modelo;
	private double valorDiaria;

	public Veiculo(String placa, String modelo, double valorDiaria) {
		this.id = contadorId++;
		this.placa = placa;
		this.modelo = modelo;
		this.valorDiaria = valorDiaria;
	}

	public abstract double calcularCustoManutencao();

	public int getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", valorDiaria=" + valorDiaria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return id == other.id;
	}

}