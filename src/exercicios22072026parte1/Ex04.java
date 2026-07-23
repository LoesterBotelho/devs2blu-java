package exercicios22072026parte1;

public class Ex04 {

	private double numeroA = 0.0;
	private double numeroB = 0.0;
	private char operacao = '+'; 

	public String getOperacaoTexto() {
		if (this.operacao == '+') {
			return "Soma";
		} else if (this.operacao == '-') {
			return "Subtração";
		} else if (this.operacao == '*') {
			return "Multiplicação";
		} else if (this.operacao == '/') {
			return "Divisão";

		} else {
			return "Operação inválida";
			
		}
	}
	
	public double getResultado() {

		if (this.operacao == '+') {
			return this.numeroA + this.numeroB;
		} else if (this.operacao == '-') {
			return this.numeroA - this.numeroB;
		} else if (this.operacao == '*') {
			return this.numeroA * this.numeroB;
		} else if (this.operacao == '/') {
			return this.numeroA / this.numeroB;

		} else {
			System.out.println("Operação inválida");
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

	public char getOperacao() {
		return operacao;
	}

	public void setOperacao(char operacao) {
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
