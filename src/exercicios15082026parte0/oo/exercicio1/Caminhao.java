package exercicios15082026parte0.oo.exercicio1;

public class Caminhao extends Veiculo implements Tributavel {
	private double capacidadeCarga;

	public Caminhao(String placa, String modelo, double valorDiaria, double capacidadeCarga) {
		super(placa, modelo, valorDiaria);
		this.capacidadeCarga = capacidadeCarga;
	}

	@Override
	public double calcularCustoManutencao() {
		return (getValorDiaria() * 0.15) + (capacidadeCarga * 100);
	}

	@Override
	public double calcularImpostoAnual() {
		return getValorDiaria() * 60;
	}

	@Override
	public String toString() {
		return "Caminhao [capacidadeCarga=" + capacidadeCarga + "]";
	}

}