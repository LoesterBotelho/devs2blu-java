package exercicios30072026parte1.oo.exercicio3.classes;

public class ContaCorrente {

	private int numero;
	private double saldo;
	private boolean especial;
	private double limite;

	public ContaCorrente(int numero, double saldoInicial, boolean especial, double limite) {
		this.numero = numero;
		this.saldo = saldoInicial;
		this.especial = especial;
		this.limite = limite;
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}

	public boolean sacar(double valor) {
		double saldoDisponivel = this.saldo + this.limite;
		
		if (valor > 0 && valor <= saldoDisponivel) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public double consultarSaldo() {
		return this.saldo;
	}

	public boolean estaUsandoChequeEspecial() {
		return this.saldo < 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + 
				", saldo=" + saldo +
				", especial=" + especial + 
				", limite=" + limite
				+ "]";
	}
	
}