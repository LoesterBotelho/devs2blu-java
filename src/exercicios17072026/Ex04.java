package exercicios17072026;

import java.time.LocalDate;

public class Ex04 {

	private int anoNascimento = 0;
	private int idade = 0;
	private int anoAtual = LocalDate.now().getYear();
	
	public double getAnoNascimento() {
		return anoNascimento;
	}
	
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	
	public int getIdade() {
		this.idade = (anoAtual - anoNascimento);
		return this.idade;
	}

	@Override
	public String toString() {
		return "Ex04 [anoNascimento=" + anoNascimento + ", idade=" + idade + ", anoAtual=" + anoAtual + "]";
	}

}
