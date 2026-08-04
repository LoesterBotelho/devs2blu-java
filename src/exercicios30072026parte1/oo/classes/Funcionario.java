package exercicios30072026parte1.oo.classes;

public abstract class Funcionario {
	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	private String numeroCtps;
	private double salario;

	public Funcionario(String nome, String endereco, String telefone, String cpf, String numeroCtps, double salario) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.numeroCtps = numeroCtps;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroCtps() {
		return numeroCtps;
	}

	public void setNumeroCtps(String numeroCtps) {
		this.numeroCtps = numeroCtps;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + 
				", endereco=" + endereco + 
				", telefone=" + telefone + 
				", cpf=" + cpf + 
				", numeroCtps=" + numeroCtps + 
				", salario=" + salario + 
				"]";
	}

}