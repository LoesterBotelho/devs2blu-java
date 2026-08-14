package exercicios13082026parte0.oo.heranca.exercicio04;

public class Gerente extends Funcionario {

	private String departamento;

	public Gerente() {
		super();
	}

	public Gerente(String nome, int idade, String cpf, String nacionalidade, double salario, String departamento) {

		super(nome, idade, cpf, nacionalidade, salario);

		this.departamento = departamento;
	}

	@Override
	public void apresentar() {

		super.apresentar();

		System.out.println("Departamento: " + departamento);
	}
}