package exercicios19072026parte1;

import java.util.Scanner;

public class Ex06Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex06 ex06 = new Ex06();

        System.out.print("Digite o tempo em segundos: ");
        int segundos = sc.nextInt();

        ex06.setSegundos(segundos);

        System.out.println("Horas: " + ex06.getHoras());
        System.out.println("Minutos: " + ex06.getMinutos());
        System.out.println("Segundos restantes: " + ex06.getSegundosRestantes());

        System.out.println(ex06);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}