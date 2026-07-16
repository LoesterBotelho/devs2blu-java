package test;

import java.util.Scanner;

public class SistemaEscolar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Aluno[] alunos = new Aluno[10];

        int quantidade = 0;
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n====================");
            System.out.println(" SISTEMA ESCOLAR");
            System.out.println("====================");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Exibir médias");
            System.out.println("4 - Exemplo de Cast");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    if (quantidade >= alunos.length) {
                        System.out.println("Limite atingido.");
                        break;
                    }

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Nota 1: ");
                    double n1 = scanner.nextDouble();

                    System.out.print("Nota 2: ");
                    double n2 = scanner.nextDouble();

                    System.out.print("Nota 3: ");
                    double n3 = scanner.nextDouble();

                    System.out.print("Nota 4: ");
                    double n4 = scanner.nextDouble();

                    alunos[quantidade] =
                            new Aluno(nome, n1, n2, n3, n4);

                    quantidade++;

                    System.out.println("Aluno cadastrado.");

                    break;

                case 2:

                    System.out.println("\nLISTA DE ALUNOS");

                    for (int i = 0; i < quantidade; i++) {

                        System.out.println(
                                (i + 1) + " - "
                                + alunos[i].getNome());
                    }

                    break;

                case 3:

                    System.out.println("\nRELATÓRIO");

                    for (Aluno aluno : alunos) {

                        if (aluno != null) {

                            System.out.println("----------------");

                            System.out.println(
                                    "Nome: "
                                    + aluno.getNome());

                            System.out.printf(
                                    "Média: %.2f%n",
                                    aluno.calcularMedia());

                            System.out.println(
                                    "Situação: "
                                    + aluno.situacao());
                        }
                    }

                    break;

                case 4:

                    System.out.println("\nEXEMPLO DE CAST");

                    double valor = 8.75;

                    int inteiro = (int) valor;

                    long numeroLong = inteiro;

                    Double wrapper = valor;

                    double primitivo = wrapper;

                    System.out.println("double = " + valor);
                    System.out.println("int = " + inteiro);
                    System.out.println("long = " + numeroLong);
                    System.out.println("Double = " + wrapper);
                    System.out.println("double = " + primitivo);

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}