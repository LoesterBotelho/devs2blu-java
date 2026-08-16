package exercicios15082026parte0.oo.exercicio1;

public class Carro extends Veiculo implements Tributavel {
	private int qtdPortas;
	
	

	public Carro(String placa, String modelo, double valorDiaria) {
		super(placa, modelo, valorDiaria);
		this.qtdPortas = 4;
	}

	public Carro(String placa, String modelo, double valorDiaria, int qtdPortas) {
		super(placa, modelo, valorDiaria);
		this.qtdPortas = qtdPortas;
	}

	@Override
	public double calcularCustoManutencao() {
		return (getValorDiaria() * 0.08) + 50.0;
	}

	@Override
	public double calcularImpostoAnual() {
		return getValorDiaria() * 30;
	}

	@Override
	public String toString() {
		return "Carro [qtdPortas=" + qtdPortas + "]";
	}
}