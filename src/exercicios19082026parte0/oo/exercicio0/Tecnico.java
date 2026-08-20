package exercicios19082026parte0.oo.exercicio0;

public class Tecnico extends Assistente {

	private double bonusSalarial;
	
	public Tecnico() {
		super();
	}

	public Tecnico(String matricula, String nome, double salario, double bonusSalarial) {
		super(matricula, nome, salario);
		this.bonusSalarial = bonusSalarial;
	}
	
	public double getBonusSalarial() {
		return bonusSalarial;
	}

	public void setBonusSalarial(double bonusSalarial) {
		this.bonusSalarial = bonusSalarial;
	}

	@Override
	public double getGanhoAnual() {
	    return super.getGanhoAnual() + this.bonusSalarial;
	}
	
	@Override
	public void exibirGanhoAnual() {
		System.out.println( this.getGanhoAnual() );
	}
	
	@Override
	public void exibeDados() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		
		return "Tecnico [" +
				"matricula=" + this.getMatricula() +
				", nome=" + this.getNome() + 
				", salario=" + this.getSalario() +
				", bonusSalarial=" + this.getBonusSalarial() +
				", GanhoAnual=" + this.getGanhoAnual() +				
				"]";
	}
	
}
