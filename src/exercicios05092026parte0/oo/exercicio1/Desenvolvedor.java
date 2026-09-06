package exercicios05092026parte0.oo.exercicio1;

class Desenvolvedor extends Funcionario {
	private String linguagem;

	public Desenvolvedor() {

	}

	public Desenvolvedor(String nome, double salario, String linguagem) {
		super(nome, salario);
		this.linguagem = linguagem;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	@Override
	public String toString() {
		return "Desenvolvedor [linguagem=" + getLinguagem() + 
				", getNome()=" + getNome() + 
				", getSalario()=" + getSalario() +
				"]";
	}

}