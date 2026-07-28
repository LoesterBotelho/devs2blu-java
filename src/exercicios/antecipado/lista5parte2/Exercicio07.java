package exercicios.antecipado.lista5parte2;

public class Exercicio07 {

	public static void main(String[] args) {

		double populacaoA = 80000;
		double populacaoB = 200000;

		int anos = 0;

		while (populacaoA < populacaoB) {

			populacaoA = populacaoA * 1.03;
			populacaoB = populacaoB * 1.015;

			anos++;
		}

		System.out.println("Anos necessários: " + anos);
		System.out.printf("População A: %.0f%n", populacaoA);
		System.out.printf("População B: %.0f%n", populacaoB);

	}

}