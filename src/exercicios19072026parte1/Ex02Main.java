package exercicios19072026parte1;

import java.util.Scanner;

public class Ex02Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex02 ex03 = new Ex02();

        System.out.print("Digite a distância percorrida (km): ");
        double distancia = sc.nextDouble();

        System.out.print("Digite a quantidade de combustível consumida (litros): ");
        double combustivel = sc.nextDouble();

        ex03.setDistancia(distancia);
        ex03.setCombustivel(combustivel);

        System.out.printf("Consumo médio: %.2f km/L%n", ex03.getConsumoMedio());

        System.out.println(ex03);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}