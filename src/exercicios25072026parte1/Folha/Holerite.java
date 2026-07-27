package exercicios25072026parte1.Folha;

import java.util.ArrayList;
import java.util.List;

public class Holerite {

	private Funcionario funcionario;
	private List<ItemHolerite> proventos = new ArrayList<>();
	private List<ItemHolerite> descontos = new ArrayList<>();
	private List<ItemHolerite> inss = new ArrayList<>();
	private List<ItemHolerite> irrf = new ArrayList<>();

	public Holerite(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void adicionarProvento(String descricao, double valor) {
		proventos.add(new ItemHolerite(descricao, valor));
	}

	public void adicionarDesconto(String descricao, double valor) {
		descontos.add(new ItemHolerite(descricao, valor));
	}

	public void adicionarINSS(String descricao, double valor) {
		inss.add(new ItemHolerite(descricao, valor));
	}

	public void adicionarIRRF(String descricao, double valor) {
		irrf.add(new ItemHolerite(descricao, valor));
	}

	public void imprimir() {

		System.out.println();
		System.out.println("========== HOLERITE ==========");

		funcionario.imprimirDados();

		System.out.println();
		System.out.println("---- PROVENTOS ----");
		double totalProventos = 0;
		for (ItemHolerite item : proventos) {
			item.imprimir();
			totalProventos += item.getValor();
		}

		System.out.println();
		System.out.println("---- INSS ----");
		double totalInss = 0;
		for (ItemHolerite item : inss) {
			item.imprimir();
			totalInss += item.getValor();
		}

		System.out.println();
		System.out.println("---- IRRF ----");
		double totalIrrf = 0;
		for (ItemHolerite item : irrf) {
			item.imprimir();
			totalIrrf += item.getValor();
		}

		System.out.println();
		System.out.println("---- DESCONTOS ----");
		double totalDescontosOutros = 0;
		for (ItemHolerite item : descontos) {
			item.imprimir();
			totalDescontosOutros += item.getValor();
		}

		// Totais Gerais
		double totalGeralDescontos = totalInss + totalIrrf + totalDescontosOutros;
		double salarioLiquido = totalProventos - totalGeralDescontos;

		System.out.println();
		System.out.println("--------------------------------");
		System.out.printf("Total Proventos....: R$ %.2f%n", totalProventos);
		System.out.printf("Total Descontos....: R$ %.2f%n", totalGeralDescontos);
		System.out.printf("Salario Liquido....: R$ %.2f%n", salarioLiquido);
		System.out.println("--------------------------------");

	}

}