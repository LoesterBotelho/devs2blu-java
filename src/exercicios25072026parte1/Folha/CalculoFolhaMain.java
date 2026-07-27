package exercicios25072026parte1.Folha;

public class CalculoFolhaMain {

	public static void main(String[] args) {

		System.out.println("TESTE CALCULO DE FOLHA");

		CalculoFolha calculo = new CalculoFolha();
		double salario = 6500.00;
		double inss = calculo.calcularINSS(salario);
		double irrf = calculo.calcularIRRF(salario, inss);
		double salarioLiquido = calculo.calcularSalarioLiquido(salario);

		System.out.printf("Salario Bruto....: R$ %.2f%n", salario);
		System.out.printf("INSS.............: R$ %.2f%n", inss);
		System.out.printf("IRRF.............: R$ %.2f%n", irrf);
		System.out.printf("Salario Liquido..: R$ %.2f%n", salarioLiquido);

	}

}