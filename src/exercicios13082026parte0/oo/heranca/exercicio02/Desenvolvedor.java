package exercicios13082026parte0.oo.heranca.exercicio02;

public class Desenvolvedor extends Funcionario {

	private String linguagem;

	public Desenvolvedor(String nome, int idade, double salario, String linguagem) {
		super(nome, idade, salario);
		this.linguagem = linguagem;
	}

	@Override
	public void apresentar() {
		System.out.println("Sou o desenvolvedor " + getNome() + " e programo em " + linguagem);
	}
}