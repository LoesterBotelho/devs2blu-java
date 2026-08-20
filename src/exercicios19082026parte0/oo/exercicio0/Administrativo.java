package exercicios19082026parte0.oo.exercicio0;

public class Administrativo extends Assistente {

	private String turno;
	private double adicionalNoturno;
	
	public Administrativo() {
		super();
	}

	public Administrativo(String matricula, String nome, double salario, String turno, double adicionalNoturno) {
		super(matricula, nome, salario);
		this.turno = turno;
		this.adicionalNoturno = adicionalNoturno;
	}

	
	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setAdicionalNoturno(double adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}

	@Override
	public double getGanhoAnual() {
	    return super.getGanhoAnual() +
	           ("NOITE".equals(this.turno) ? this.adicionalNoturno : 0);
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
		
		return "Administrativo [" +
				"matricula=" + this.getMatricula() +
				", nome=" + this.getNome() + 
				", salario=" + this.getSalario() +
				", turno=" + this.getTurno() +
				", adicionalNoturno=" + this.getAdicionalNoturno() +
				", GanhoAnual=" + this.getGanhoAnual() +				
				"]";
	}
	
}
