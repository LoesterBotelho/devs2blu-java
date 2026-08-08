package exercicios07082026parte1.exercicio1;

public class Pessoa {

	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public void apresentar() {
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + 
				", cpf=" + cpf + 
				"]";
	}

}