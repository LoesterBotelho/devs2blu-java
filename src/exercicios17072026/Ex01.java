package exercicios17072026;

public class Ex01 {

	private static final double REAJUSTE = 0.01; // CONSTANTE
	private double saldo = 0.0;
	
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
		return "Ex01 [saldo=" + saldo + "," + " ValorReajustado=" + this.getValorReajustado() + "]";
	}
			
	
}
