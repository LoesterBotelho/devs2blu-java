package exercicios.antecipado.arrayvetores;

public class Filho {

	private String nome;
	private int idade;

	public Filho(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return nome + " - " + idade + " anos";
	}
}