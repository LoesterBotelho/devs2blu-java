package exercicios13082026parte0.oo.heranca.exercicio04;

public class Funcionario extends Pessoa {

	private double salario;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, int idade, String cpf, String nacionalidade, double salario) {

		super(nome, idade, cpf, nacionalidade);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public void apresentar() {

		super.apresentar();

		System.out.println("Salário: " + salario);

		// protected -> pode acessar
		System.out.println("Idade (protected): " + idade);

		// default -> mesmo pacote
		System.out.println("CPF: " + cpf);

		// public
		System.out.println("Nacionalidade: " + nacionalidade);

		// private -> NÃO COMPILA
		// System.out.println(nome);
	}
}