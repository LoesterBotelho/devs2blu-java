package exercicios22072026parte1;

import java.util.Scanner;

public class Ex09Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex09 ex09 = new Ex09();

        System.out.print("Digite uma letra: ");
        ex09.setLetra(sc.next().charAt(0));

        System.out.println("\nLetra: " + ex09.getLetra());
        System.out.println("Classificação: " + ex09.getClassificacao());

        System.out.println("\n" + ex09);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}