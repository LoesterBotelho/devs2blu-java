package exercicios19072026parte1;

import java.util.Scanner;

public class Ex11Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex11 ex11 = new Ex11();

        System.out.print("Digite a distância da viagem (km): ");
        double distancia = sc.nextDouble();

        System.out.print("Digite a velocidade média (km/h): ");
        double velocidadeMedia = sc.nextDouble();

        ex11.setDistancia(distancia);
        ex11.setVelocidadeMedia(velocidadeMedia);

        System.out.printf("Tempo da viagem: %.2f horas%n", ex11.getTempoHoras());
        System.out.printf("Tempo da viagem: %.2f minutos%n", ex11.getTempoMinutos());

        System.out.println(ex11);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}