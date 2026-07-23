package exercicios22072026parte1;

import java.util.Scanner;

public class Ex07Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex07 ex07 = new Ex07();

        System.out.print("Digite o primeiro número : ");
        ex07.setNumeroA(sc.nextDouble());

        System.out.print("Digite o segundo número : ");
        ex07.setNumeroB(sc.nextDouble());

        System.out.println("\n MENU");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.print("Escolha uma operação: ");

        ex07.setOperacao(sc.nextInt());

        // Validação da divisão por zero
        if (ex07.getOperacao() == 4 && ex07.getNumeroB() == 0) {
            System.out.println("\nErro: Não é possível dividir por zero.");
        } else {
            System.out.printf(
                "\nO resultado da operação %s é: %.2f%n",
                ex07.getOperacaoTexto(),
                ex07.getResultado()
            );

            System.out.println("\n" + ex07);
        }

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }
}