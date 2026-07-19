package exercicios19072026parte1;

import java.util.Scanner;

public class Ex07Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex07 ex07 = new Ex07();

        System.out.print("Digite a largura da parede (m): ");
        double largura = sc.nextDouble();

        System.out.print("Digite a altura da parede (m): ");
        double altura = sc.nextDouble();

        ex07.setLargura(largura);
        ex07.setAltura(altura);

        System.out.printf("Área da parede: %.2f m²%n", ex07.getArea());
        System.out.printf("Litros de tinta necessários: %.2f L%n", ex07.getLitrosTinta());

        System.out.println(ex07);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}