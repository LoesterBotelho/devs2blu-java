package exercicios17072026;

public class Ex03 {

	private double valor01 = 0.0;
	private double valor02 = 0.0;
	private double soma = 0.0;
	private double dobro = 0.0;
	
	public double getValor01() {
		return valor01;
	}
	
	public void setValor01(double valor01) {
		this.valor01 = valor01;
	}
	
	public double getValor02() {
		return valor02;
	}
	
	public void setValor02(double valor02) {		
		this.valor02 = valor02;
	}
	
	public double getSoma() {
		this.soma = this.valor01 + this.valor02;
		return this.soma;
	}
	
	public double getDobro() {
		this.dobro = (this.valor01 + this.valor02) * 2;		
		return dobro;
	}
	
	@Override
	public String toString() {
		return "Ex03 [valor01=" + valor01 + ", valor02=" + valor02 + ", soma=" + soma + ", dobro=" + dobro + "]";
	}
	
}
