package exercicios25072026parte1.contabil.test;

import exercicios25072026parte1.contabil.config.ContabilContext;

public class PlanoContaTest {

	public static void main(String[] args) {

		ContabilContext context = new ContabilContext();

		context.getPlanoContaService()

				.listar()

				.forEach(

						System.out::println

				);

	}

}