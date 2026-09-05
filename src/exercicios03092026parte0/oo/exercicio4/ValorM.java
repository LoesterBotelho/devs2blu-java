package exercicios03092026parte0.oo.exercicio4;

class ValorM {
	private double valor;
	private String moeda;

	public ValorM(double valor, String moeda) {
		this.valor = valor;
		this.moeda = moeda;
	}

	public double getValor() {
		return valor;
	}

	public String getMoeda() {
		return moeda;
	}

	@Override
	public String toString() {
		return moeda + " " + String.format("%.2f", valor);
	}
}