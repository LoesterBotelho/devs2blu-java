package exercicios17072026parte1;

public class Ex02 {

	private double mediaAritimetica = 0.0;
	private String nome = "";
	private double nota1 = 0.0;
	private double nota2 = 0.0;
	private double nota3 = 0.0;
	private double nota4 = 0.0;
	
	
	
	public Ex02() { }

	public Ex02(double nota1, double nota2, double nota3, double nota4) {		
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.calcularMediaAritimetica();
	}

	public Ex02(String nome, double nota1, double nota2, double nota3, double nota4) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.calcularMediaAritimetica();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double getNota4() {
		return nota4;
	}

	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}

	public double calcularMediaAritimetica() {
		this.mediaAritimetica = (nota1 + nota2 + nota3 + nota4) / 4;
		return this.mediaAritimetica;
	}

	public String calcularMediaAritimeticaToString() {	
		return Double.toString( this.calcularMediaAritimetica() );
	}
	
	@Override
	public String toString() {
		return "Ex02 [nome=" + this.getNome() +
				", mediaAritimetica=" + this.calcularMediaAritimeticaToString() + 
				", nota1=" + this.getNota1() + 
				", nota2=" + this.getNota2() + 
				", nota3=" + this.getNota3() + 
				", nota4=" + this.getNota4() + 				
				"]";
	}
	
	
}


