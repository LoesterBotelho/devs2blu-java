package exercicios19072026parte1;

import java.util.Scanner;

public class Ex01Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex01 ex01 = new Ex01();

        System.out.print("Digite a temperatura em Celsius: ");
        double entrada = sc.nextDouble();

        ex01.setCelsius(entrada);

        System.out.printf("Fahrenheit: %.2f °F%n", ex01.getFahrenheit());
        System.out.printf("Kelvin: %.2f K%n", ex01.getKelvin());

        System.out.println(ex01);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}