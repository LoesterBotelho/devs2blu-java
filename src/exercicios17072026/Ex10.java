package exercicios17072026;

public class Ex10 {

	private double salarioBase = 0;
	private double gratificacao = 0;
	private double imposto = 0;
	private double salarioReceber = 0;

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getGratificacao() {
		this.gratificacao = this.salarioBase * 0.05;
		return this.gratificacao;
	}

	public double getImposto() {
		this.imposto = this.salarioBase * 0.07;
		return this.imposto;
	}

	public double getSalarioReceber() {
		this.salarioReceber = this.salarioBase + getGratificacao() - getImposto();
		return this.salarioReceber;
	}

	@Override
	public String toString() {
		return "Ex10 [salarioBase=" + salarioBase + ", gratificacao="
				+ gratificacao + ", imposto=" + imposto
				+ ", salarioReceber=" + salarioReceber + "]";
	}

}