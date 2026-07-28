package exercicios25072026parte1.contabil.test;

import exercicios25072026parte1.contabil.initializer.ContabilDataInitializer;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;

public class ContabilInitializerTest {

	public static void main(String[] args) {

		PlanoContaRepository repository = new PlanoContaRepository();

		ContabilDataInitializer initializer = new ContabilDataInitializer(repository);

		initializer.carregar();

		repository.listar()

				.forEach(conta -> {

					conta.imprimir("");

					System.out.println();

				});

	}

}