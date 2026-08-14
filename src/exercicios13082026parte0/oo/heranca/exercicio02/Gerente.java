package exercicios13082026parte0.oo.heranca.exercicio02;

public class Gerente extends Funcionario {

	public Gerente(String nome, int idade, double salario) {
		super(nome, idade, salario);
	}

	@Override
	public void apresentar() {
		System.out.println("Sou o gerente " + getNome());
	}
}