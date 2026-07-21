package exercicios17072026parte1;

import java.time.LocalDate;

public class Ex04 {

	private int anoNascimento = 0;

	public Ex04() { }

	public Ex04(int anoNascimento) {
		this.anoNascimento = anoNascimento;	
	}

	public double getAnoNascimento() {
		return anoNascimento;
	}
	
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	
	public int getIdade() {
		var anoAtual = LocalDate.now().getYear();
		return (anoAtual - anoNascimento);
	}

	@Override
	public String toString() {
		return "Ex04 [anoNascimento=" + this.getAnoNascimento() + 
				", idade=" + this.getIdade() +
				", anoAtual=" + this.getAnoNascimento() +
				"]";
	}

}
