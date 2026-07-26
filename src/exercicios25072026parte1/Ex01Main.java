package exercicios25072026parte1;

import java.util.Scanner;

public class Ex01Main {

	private static final String div = "----------------------------------------";
	public static void main(String[] args) {

		getAuthor();

		Scanner sc = new Scanner(System.in);

		Ex01 ex04 = new Ex01();

		final int TOTAL = 5; // 5 ALUNOS A SEREM CADASTRADOS

		String[] nomes = new String[TOTAL];
		double[][] notas = new double[5][4];		
		double[] mediaAritmetica = new double[TOTAL];
		double[] mediaPonderada = new double[TOTAL];
		double[] mediana = new double[TOTAL];
		double[] nota100 = new double[TOTAL];

		System.out.println("CADASTRO DOS ALUNOS");

		for (int i = 0; i < TOTAL; i++) {

			System.out.println();

			System.out.print("Nome: ");
			nomes[i] = sc.next();

		    for (int j = 0; j < 4; j++) {

		        System.out.print("Nota " + (j + 1) + ": ");
		        notas[i][j] = sc.nextDouble();

		    }

			mediaAritmetica[i] = ex04.calcularMediaAritmetica(notas[i][0], notas[i][1], notas[i][2], notas[i][3]);
			mediaPonderada[i] = ex04.calcularMediaPonderada(notas[i][0], notas[i][1], notas[i][2], notas[i][3]);
			mediana[i] = ex04.calcularMediana(notas[i][0], notas[i][1], notas[i][2], notas[i][3]);
			nota100[i] = ex04.calcularNota100(mediaAritmetica[i]);

		}

		int opcao;

		do {

			System.out.println();
			System.out.println(div);
			System.out.println("MENU");
			System.out.println(div);
			System.out.println("1 - Listar alunos");
			System.out.println("2 - Média da turma");
			System.out.println("3 - Procurar aluno");
			System.out.println("4 - Sair");
			System.out.print("Opção: ");

			opcao = sc.nextInt();

			switch (opcao) {

			case 1:

				for (int i = 0; i < TOTAL; i++) {

					System.out.println();
					System.out.println(div);
					System.out.println("Aluno...............: " + nomes[i]);
					System.out.printf("Nota 1...............: %.2f%n", notas[i][0]);
					System.out.printf("Nota 2...............: %.2f%n", notas[i][1]);
					System.out.printf("Nota 3...............: %.2f%n", notas[i][2]);
					System.out.printf("Nota 4...............: %.2f%n", notas[i][3]);
					System.out.printf("Media Aritmetica.....: %.2f%n", mediaAritmetica[i]);
					System.out.printf("Media Ponderada......: %.2f%n", mediaPonderada[i]);
					System.out.printf("Mediana..............: %.2f%n", mediana[i]);
					System.out.printf("Nota (0-100).........: %.2f%n", nota100[i]);
					System.out.println("Conceito............: " + ex04.getConceito(nota100[i]));
					System.out.println("Situacao............: " + ex04.getSituacao(mediaAritmetica[i]));
					System.out.println(div);

				}

				break;

			case 2:

				double soma = 0;

				for (int i = 0; i < TOTAL; i++) {
					soma += mediaAritmetica[i];
				}

				System.out.printf("\nMedia da Turma: %.2f%n", soma / TOTAL);

				break;

			case 3:

				int resposta = 1;

				while (resposta == 1) {

					System.out.print("Digite o nome: ");

					String procura = sc.next();

					boolean encontrou = false;

					for (int i = 0; i < TOTAL; i++) {

						if (nomes[i].equalsIgnoreCase(procura)) {

							System.out.println();
							System.out.println("Aluno encontrado");
							System.out.println(div);
							System.out.println("Nome...............: " + nomes[i]);
							System.out.printf("Media Aritmetica....: %.2f%n", mediaAritmetica[i]);
							System.out.printf("Media Ponderada.....: %.2f%n", mediaPonderada[i]);
							System.out.printf("Mediana.............: %.2f%n", mediana[i]);
							System.out.printf("Nota 0-100..........: %.2f%n", nota100[i]);
							System.out.println("Conceito...........: " + ex04.getConceito(nota100[i]));
							System.out.println("Situacao...........: " + ex04.getSituacao(mediaAritmetica[i]));

							encontrou = true;
							break;

						}

					}

					if (!encontrou) {

						System.out.println("Aluno não encontrado.");
						System.out.println("1 - Procurar novamente");
						System.out.println("2 - Voltar");

						resposta = sc.nextInt();

					} else {

						resposta = 2;

					}

				}

				break;

			case 4:

				System.out.println("Programa encerrado.");
				break;

			default:
				System.out.println("Opção inválida.");

			}

		} while (opcao != 4);

		sc.close();

	}

	public static void getAuthor() {
		System.out.println(div);
		System.out.println("Author : Loester Botelho");
		System.out.println(div);
		System.out.println();
	}

}