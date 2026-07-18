package exercicios17072026parte2;

public class Ex02 {

	private double ladoQuadrado = 0.0;
	private double area = 0.0;
	private double perimetro = 0.0;
	
	public Ex02() {}

	public Ex02(double ladoQuadrado) {
		this.ladoQuadrado = ladoQuadrado;
		getArea();
		getPerimetro();
	}

	public double getLadoQuadrado() {
		return ladoQuadrado;		
	}
	
	public void setLadoQuadrado(double ladoQuadrado) {
		this.ladoQuadrado = ladoQuadrado;
		getArea();
		getPerimetro();
	}
	
	public double getArea() {
		this.area = this.ladoQuadrado * this.ladoQuadrado;
		return this.area;
	}
	
	public double getPerimetro() {
		this.perimetro = this.ladoQuadrado * 4;
		return this.perimetro;
	}

	@Override
	public String toString() {
		return "Ex02 [ladoQuadrado=" + this.getLadoQuadrado() + ", area=" + this.getArea() + ", perimetro=" + this.getPerimetro() + "]";
	}
			
}
