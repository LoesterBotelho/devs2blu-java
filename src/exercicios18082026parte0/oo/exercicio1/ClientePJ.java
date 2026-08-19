package exercicios18082026parte0.oo.exercicio1;

public class ClientePJ extends EntidadeBase implements Tributavel {
	private String empresa;
	private double faturamento;

	public ClientePJ() {
		super();
		this.empresa = "Empresa X";
		this.faturamento = 10000.0;
	}

	public ClientePJ(String empresa, double faturamento) {
		this();
		this.empresa = empresa;
		this.faturamento = faturamento;
	}

	@Override
	public double calcularTributo() {
		return this.faturamento * 0.15;
	}

	@Override
	public String toString() {
		return super.toString() + " - Empresa: " + empresa + 
				", Faturamento: " + faturamento;
	}
}