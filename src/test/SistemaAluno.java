package test;

import java.util.Scanner;

public class SistemaAluno {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o ENTER

            switch (opcao) {

                case 1:

                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();

                    System.out.print("Nota 1: ");
                    double nota1 = scanner.nextDouble();

                    System.out.print("Nota 2: ");
                    double nota2 = scanner.nextDouble();

                    System.out.print("Nota 3: ");
                    double nota3 = scanner.nextDouble();

                    System.out.print("Nota 4: ");
                    double nota4 = scanner.nextDouble();

                    double media = (nota1 + nota2 + nota3 + nota4) / 4;

                    System.out.println("\nAluno: " + nome);
                    System.out.println("Média: " + media);

                    if (media >= 7) {
                        System.out.println("Situação: APROVADO");
                    } else {
                        System.out.println("Situação: REPROVADO");
                    }

                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}