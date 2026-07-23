package exercicios22072026parte1;

import java.util.Scanner;

public class Ex10Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex10 ex10 = new Ex10();

        System.out.print("Digite um ano : ");
        ex10.setAno(sc.nextInt());

        System.out.println();

        System.out.println("Ano informado : " 
                + ex10.getAno());

        System.out.println("Resultado : "
                + ex10.getResultado());

        System.out.println("\n" + ex10);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }
}