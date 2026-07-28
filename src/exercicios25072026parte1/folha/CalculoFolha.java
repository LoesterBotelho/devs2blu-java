package exercicios25072026parte1.folha;

public class CalculoFolha {

	private TabelaINSS tabelaINSS;
	private TabelaIRRF tabelaIRRF;

	public CalculoFolha() {

		tabelaINSS = new TabelaINSS();
		tabelaIRRF = new TabelaIRRF();

	}

	public double calcularINSS(double salario) {

		return tabelaINSS.calcularINSS(salario);

	}

	public double calcularIRRF(double salario, double inss) {

		double base = salario - inss;

		return tabelaIRRF.calcularIRRF(base);

	}

	public double calcularSalarioLiquido(double salario) {

		double inss = calcularINSS(salario);
		double irrf = calcularIRRF(salario, inss);

		return salario - inss - irrf;

	}

}