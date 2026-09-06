package exercicios05092026parte0.oo.exercicio1;

class Gerente extends Funcionario {
	private double bonus;

	public Gerente(String nome, double salario, double bonus) {
		super(nome, salario);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Gerente [bonus=" + getBonus() + 
				", getNome()=" + getNome() + 
				", getSalario()=" + getSalario() +
				"]";
	}

}