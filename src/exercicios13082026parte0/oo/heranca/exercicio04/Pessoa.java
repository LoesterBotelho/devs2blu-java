package exercicios13082026parte0.oo.heranca.exercicio04;

public class Pessoa {

	// private -> somente a própria classe
	private String nome;

	// protected -> classe e subclasses
	protected int idade;

	// default -> somente classes do mesmo pacote
	String cpf;

	// public -> qualquer classe
	public String nacionalidade;

	public Pessoa() {
		this("Sem Nome", 0, "", "Brasileiro");
	}

	public Pessoa(String nome) {
		this(nome, 0, "", "Brasileiro");
	}

	public Pessoa(String nome, int idade, String cpf, String nacionalidade) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.nacionalidade = nacionalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void apresentar() {
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
	}
}