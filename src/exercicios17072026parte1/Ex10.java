package exercicios17072026parte1;

public class Ex10 {

	private double salarioBase = 0;

	public Ex10() { }

	public Ex10(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getGratificacao() {
		return this.salarioBase * 0.05;
	}

	public double getImposto() {
		return this.salarioBase * 0.07;
	}

	public double getSalarioReceber() {
		return this.salarioBase + getGratificacao() - getImposto();
	}

	@Override
	public String toString() {
		return "Ex10 [salarioBase=" + this.getSalarioBase() + 
				", gratificacao=" + this.getGratificacao() + 
				", imposto=" + this.getImposto() + 
				", salarioReceber=" + this.getSalarioReceber() +
				"]";
	}

}