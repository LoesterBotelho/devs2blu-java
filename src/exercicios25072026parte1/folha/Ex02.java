package exercicios25072026parte1.folha;

public class Ex02 {

	private CalculoFolha calculoFolha;

	public Ex02() {
		this.calculoFolha = new CalculoFolha();
	}

	public Holerite gerarHolerite(Funcionario funcionario) {

		Holerite holerite = new Holerite(funcionario);

		double salarioBase = funcionario.getSalarioBase();

		holerite.adicionarProvento("Salario Base", salarioBase);
		holerite.adicionarProvento("Vale Alimentacao", 650.00);
		holerite.adicionarProvento("Premio Produtividade", 400.00);

		double inss = calculoFolha.calcularINSS(salarioBase);
		double irrf = calculoFolha.calcularIRRF(salarioBase, inss);

		holerite.adicionarINSS("Desconto INSS", inss);
		holerite.adicionarIRRF("Desconto IRRF", irrf);

		int qtdDependentes = funcionario.getDependentes().size();
		if (qtdDependentes > 0) {
			holerite.adicionarIRRF("Dedução por Dependente (" + qtdDependentes + ")", qtdDependentes * 189.59);
		}

		holerite.adicionarDesconto("Vale Transporte", 250.00);
		holerite.adicionarDesconto("Plano Saude", 180.00);
		holerite.adicionarDesconto("Seguro Vida", 25.00);

		return holerite;

	}

}