package exercicios17072026parte1;

public class Ex01 {

	private static final double REAJUSTE = 0.01; // CONSTANTE
	private double saldo = 0.0;
	
	public Ex01() { }
	
	public Ex01(double saldo) {
		this.saldo = saldo;
		this.getValorReajustado();
	}

	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getValorReajustado() {
		return saldo * REAJUSTE;
	}

	@Override
	public String toString() {
		return "Ex01 [saldo=" + this.getSaldo() + 
				"," + " ValorReajustado=" + this.getValorReajustado() + 
				"]";
	}
			
	
}
