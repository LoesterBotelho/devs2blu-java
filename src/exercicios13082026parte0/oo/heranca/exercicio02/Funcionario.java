package exercicios13082026parte0.oo.heranca.exercicio02;

public class Funcionario extends Pessoa {

	private double salario;

	public Funcionario(String nome, int idade, double salario) {
		super(nome, idade);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	@Override
	public void apresentar() {
		System.out.println("Sou o funcionário " + getNome());
	}
}