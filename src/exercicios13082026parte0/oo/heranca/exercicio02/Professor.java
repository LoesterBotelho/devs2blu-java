package exercicios13082026parte0.oo.heranca.exercicio02;

public class Professor extends Funcionario {

	private String disciplina;

	public Professor(String nome, int idade, double salario, String disciplina) {
		super(nome, idade, salario);
		this.disciplina = disciplina;
	}

	@Override
	public void apresentar() {
		System.out.println("Sou o professor " + getNome() + " da disciplina " + disciplina);
	}
}