package exercicios17072026parte2;

public class Ex05 {

	private double a = 0.0;
	private double b = 0.0;
	private double c = 0.0;
	private double d = 0.0;
	private double e = 0.0;
	private double f = 0.0;
	private double denominador = 0.0;
	private double x = 0.0;
	private double y = 0.0;
	
	public Ex05() { }
	
	public Ex05(double a, double b, double c, double d, double e, double f) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		getX();
		getY();
	}

	public double getA() {
		return a;
	}
	
	public void setA(double a) {
		this.a = a;
	}
	
	public double getB() {
		return b;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	public double getC() {
		return c;
	}
	
	public void setC(double c) {
		this.c = c;
	}
	
	public double getD() {
		return d;
	}
	
	public void setD(double d) {
		this.d = d;
	}
	
	public double getE() {
		return e;
	}
	
	public void setE(double e) {
		this.e = e;
	}
	
	public double getF() {
		return f;
	}
	
	public void setF(double f) {
		this.f = f;
	}
	
	public double getDenominador() {
		this.denominador = (a * e) - (b * d);
		return this.denominador;
	}
	
	public double getX() {
		this.x = ((c * e) - (b * f)) / this.getDenominador();
		return this.x;
	}
	
	public double getY() {
		this.y = ((a * f) - (c * d)) / this.getDenominador();
		return this.y;
	}

	@Override
	public String toString() {
		return "Ex05 [a=" + a + 
				", b=" + b + 
				", c=" + c + 
				", d=" + d + 
				", e=" + e + 
				", f=" + f + 
				", denominador=" + this.getDenominador() + 
				", x=" + this.getX() + 
				", y=" + this.getY() + 
				"]";
	}
	

	
}
