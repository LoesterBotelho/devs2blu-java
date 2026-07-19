package exercicios19072026parte2;

import java.util.Scanner;

public class AlunoMain {

    public static void main(String[] args) {

        getAuthor();

        String div = "-----------------------------------------";
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos deseja cadastrar? ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Aluno[] alunos = new Aluno[quantidade];

        for (int i = 0; i < alunos.length; i++) {

            System.out.println();
            System.out.println(div);
            System.out.println("Cadastro do Aluno " + (i + 1));
            System.out.println(div);

            Aluno aluno = new Aluno();

            System.out.print("Nome: ");
            aluno.setNome(sc.nextLine());

            double[] notas = new double[4];

            for (int j = 0; j < notas.length; j++) {

                System.out.print("Digite a Nota " + (j + 1) + ": ");
                notas[j] = sc.nextDouble();

            }

            aluno.setNotas(notas);

            alunos[i] = aluno;

            sc.nextLine();
        }

        System.out.println();
        System.out.println(div);
        System.out.println("RELATÓRIO DOS ALUNOS");
        System.out.println(div);

        for (Aluno aluno : alunos) {

            System.out.println(aluno);

        }

        sc.close();

    }

    public static void getAuthor() {

        System.out.println("-----------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("-----------------------------------------");
        System.out.println();

    }

}