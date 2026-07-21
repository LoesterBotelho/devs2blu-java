package exercicios17072026parte1;

public class Ex03 {

	private double valor01 = 0.0;
	private double valor02 = 0.0;

	public Ex03() { }

	public Ex03(double valor01, double valor02) {
		this.valor01 = valor01;
		this.valor02 = valor02;
	}

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
		return this.valor01 + this.valor02;
	}
	
	public double getDobro() {
		return (this.valor01 + this.valor02) * 2;		
	}
	
	@Override
	public String toString() {
		return "Ex03 [valor01=" + this.getValor01() + 
				", valor02=" + this.getValor02() + 
				", soma=" + this.getSoma() + 
				", dobro=" + this.getDobro() + 
				"]";
	}
	
}
