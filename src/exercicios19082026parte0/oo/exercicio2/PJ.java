package exercicios19082026parte0.oo.exercicio2;

public class PJ extends contribuinte {

	private String cnpj;
	
	public PJ() {
		super();
	}

	public PJ(String nome, String cnpj, double faturamento) {
		super(nome, faturamento);
		this.cnpj = cnpj;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public double calcularValorIIRF() {	
		return this.getFaturamento() * 0.10;   ///  10/100 = 0.10 = 10%
	}
	
	@Override
	public void calcularIIRF() {

	     System.out.println("O Contribuinte PJ : " + this.getNome() +
		            " Com cnpj : " + this.getCnpj() + 
		            " Com Faturalmento Mensal de : " + this.getFaturamento() + 
	                " Com imposto devido de : " + calcularValorIIRF()
		 );
		
	}

	@Override
	public String toString() {
		return "PJ [nome=" + this.getNome() + 
				", cnpj=" + this.getCnpj() +
				", faturamentoAnual=" + this.getFaturamento() +
				", impostoDevido=" + this.calcularValorIIRF() +
				"]";
	}	
	
}
