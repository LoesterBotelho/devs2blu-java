package exercicios19082026parte0.oo.exercicio0;

public class Funcionario {

	private String nome;
	private double salario;

	public Funcionario() {

	}

	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public double getGanhoAnual() {
		return salario * 12;
	}

	public void exibirGanhoAnual() {
		System.out.println( this.getGanhoAnual() );
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
 
	public void exibeDados() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + 
				", salario=" + salario + 
				", GanhoAnual=" + this.getGanhoAnual() +
				"]";
	}

}
