package exercicios05082026parte0.oo.exemplo2;

public class Pessoa {
	public void apresentarPessoa() {
		System.out.println("Olá! Eu sou uma pessoa.");
	}

	public void apresentarPessoa(String nome) {
		System.out.println("Olá! Meu nome é " + nome);
	}

	public void apresentarPessoa(String nome, int idade) {
		System.out.println("Olá! Meu nome é " + nome + " e tenho " + idade + " anos.");
	}
}
