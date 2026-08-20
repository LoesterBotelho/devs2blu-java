package exercicios19082026parte0.oo.exercicio2;

public abstract class contribuinte {

	private String nome;
	private double faturamento;

	public contribuinte() {

	}

	public contribuinte(String nome, double faturamento) {
		this.nome = nome;
		this.faturamento = faturamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}

	@Override
	public String toString() {
		return "contribuinte [nome=" + nome + ", faturamento=" + faturamento + "]";
	}
	
	public void Exibir() {
		System.out.println( this.toString() );
	}

	public abstract void calcularIIRF();
}
