package exercicios17072026;

public class Ex02 {

	private double mediaAritimetica = 0.0;
	private double nota1 = 0.0;
	private double nota2 = 0.0;
	
	public double getNota1() {
		return nota1;
	}
	
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	
	public double getNota2() {
		return nota2;
	}
	
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	public double calcularMediaAritimetica() {
		this.mediaAritimetica = (nota1 + nota2) / 2;
		return this.mediaAritimetica;
	}

	public String calcularMediaAritimeticaToString() {
		this.calcularMediaAritimetica();
		return Double.toString(this.mediaAritimetica);
	}
	
	@Override
	public String toString() {
		return "Ex02 [mediaAritimetica=" + mediaAritimetica + ", nota1=" + nota1 + ", nota2=" + nota2 + "]";
	}
	
	
}


