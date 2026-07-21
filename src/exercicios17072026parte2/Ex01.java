package exercicios17072026parte2;

public class Ex01 {

	
	private double catetoA = 0.0;
	private double catetoB = 0.0;

	public Ex01() {	}
	
	public Ex01(double catetoA, double catetoB) {	
		this.catetoA = catetoA;
		this.catetoB = catetoB;
	}

	public double getCatetoA() {
		return catetoA;
	}
	
	public void setCatetoA(double catetoA) {
		this.catetoA = catetoA;
	}
	
	public double getCatetoB() {
		return catetoB;
	}
	
	public void setCatetoB(double catetoB) {
		this.catetoB = catetoB;
	}
	
	public double getHipotenusa() {
		return Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
	}

	@Override
	public String toString() {
		return "Ex1 [catetoA=" + this.getCatetoA() + 
				", catetoB=" + this.getCatetoB() + 
				", hipotenusa=" + this.getHipotenusa() + 
				"]";
	}

}
