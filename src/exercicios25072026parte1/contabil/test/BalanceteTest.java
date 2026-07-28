package exercicios25072026parte1.contabil.test;

import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.service.BalanceteService;

public class BalanceteTest {

	public static void main(String[] args) {

		ContabilContext context = new ContabilContext();

		BalanceteService balancete = context.getBalanceteService();

		balancete.gerar()

				.forEach(System.out::println);

		System.out.println();

		System.out.println("Balanceado: " + balancete.partidaDobradaOk());

	}

}