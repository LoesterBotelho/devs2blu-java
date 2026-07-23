package exercicios22072026parte1;

public class Ex07 {

	
	private static final int SOMA = 1;
	private static final int SUBTRACAO = 2;
	private static final int MULTIPLICACAO = 3;
	private static final int DIVISAO = 4;
	
	private double numeroA = 0.0;
	private double numeroB = 0.0;
	private int operacao = 0; 

	public String getOperacaoTexto() {
		if (this.operacao == SOMA) {
			return "Soma";
		} else if (this.operacao == SUBTRACAO) {
			return "Subtração";
		} else if (this.operacao == MULTIPLICACAO) {
			return "Multiplicação";
		} else if (this.operacao == DIVISAO) {
			return "Divisão";

		} else {
			return "Operação inválida";
			
		}
	}
	
	public double getResultado() {

		switch (this.getOperacao()) {
		  case SOMA: return this.numeroA + this.numeroB;
		  case SUBTRACAO: return this.numeroA - this.numeroB;
		  case MULTIPLICACAO: return this.numeroA * this.numeroB;
		  case DIVISAO: return this.numeroA / this.numeroB;	
		  default:			  
			  System.out.println("Opção inválida");
			  return 0.0;
		}
		
	}

	public double getNumeroA() {
		return numeroA;
	}

	public void setNumeroA(double numeroA) {
		this.numeroA = numeroA;
	}

	public double getNumeroB() {
		return numeroB;
	}

	public void setNumeroB(double numeroB) {
		this.numeroB = numeroB;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	@Override
	public String toString() {
		return "Ex04 [numeroA=" + this.getNumeroA() + 
				", numeroB=" + this.getNumeroB() + 
				", Operacao=" + this.getOperacao() + 
				", resultado=" + this.getResultado() + 
				"]";
	}
}
