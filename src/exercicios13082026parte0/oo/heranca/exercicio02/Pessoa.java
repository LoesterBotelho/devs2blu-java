package exercicios13082026parte0.oo.heranca.exercicio02;

public class Pessoa {

	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public void apresentar() {
		System.out.println("Olá, meu nome é " + nome);
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}
}