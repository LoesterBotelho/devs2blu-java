package exercicios19072026parte1;

import java.util.Scanner;

public class Ex03Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex03 ex04 = new Ex03();

        System.out.print("Digite o peso (kg): ");
        double peso = sc.nextDouble();

        System.out.print("Digite a altura (m): ");
        double altura = sc.nextDouble();

        ex04.setPeso(peso);
        ex04.setAltura(altura);

        System.out.printf("IMC: %.2f%n", ex04.getImc());

        System.out.println(ex04);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}