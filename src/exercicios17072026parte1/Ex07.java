package exercicios17072026parte1;

public class Ex07 {

	private String nome = "";
	private int idade = 0;

	public Ex07() { }

	public Ex07(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getDiasVivo() {
		return (this.idade * 365);
	}

	@Override
	public String toString() {
		return "Ex07 [nome=" + this.getNome() + 
				", idade=" + this.getIdade() + 
				", diasVivos=" + this.getDiasVivo() + 
				"]";
	}
	
}
