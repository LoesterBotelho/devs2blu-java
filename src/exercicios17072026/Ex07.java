package exercicios17072026;

public class Ex07 {

	private String nome = "";
	private int idade = 0;
	private int diasVivos = 0;
	
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
		this.diasVivos = (this.idade * 365);
		return this.diasVivos;
	}

	@Override
	public String toString() {
		return "Ex07 [nome=" + nome + ", idade=" + idade + ", diasVivos=" + diasVivos + "]";
	}
	
}
