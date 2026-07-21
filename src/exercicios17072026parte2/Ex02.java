package exercicios17072026parte2;

public class Ex02 {

	private double ladoQuadrado = 0.0;
	
	public Ex02() {}

	public Ex02(double ladoQuadrado) {
		this.ladoQuadrado = ladoQuadrado;
	}

	public double getLadoQuadrado() {
		return ladoQuadrado;		
	}
	
	public void setLadoQuadrado(double ladoQuadrado) {
		this.ladoQuadrado = ladoQuadrado;
	}
	
	public double getArea() {
		return this.ladoQuadrado * this.ladoQuadrado;
	}
	
	public double getPerimetro() {
		return this.ladoQuadrado * 4;
	}

	@Override
	public String toString() {
		return "Ex02 [ladoQuadrado=" + this.getLadoQuadrado() + 
				", area=" + this.getArea() + 
				", perimetro=" + this.getPerimetro() + 
				"]";
	}
			
}
