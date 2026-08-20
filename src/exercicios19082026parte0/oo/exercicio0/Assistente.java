package exercicios19082026parte0.oo.exercicio0;

public class Assistente extends Funcionario {

	private String matricula;

	public Assistente() {
		super();
	}

	public Assistente(String matricula, String nome, double salario) {
		super(nome, salario);		
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void addAumento(double valor) {
		this.setSalario(this.getSalario() + valor);
	}

	@Override
	public void exibeDados() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		
		return "Assistente [" +
				"matricula=" + matricula +
				", nome=" + this.getNome() + 
				", salario=" + this.getSalario() +
				", GanhoAnual=" + this.getGanhoAnual() +				
				"]";
	}

}
