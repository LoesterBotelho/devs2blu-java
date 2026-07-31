package exercicios30072026parte1.exercicio02;

public class Disciplina {

	private String nome;

	Disciplina() {
	}

	public Disciplina(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + "]";
	}

}
