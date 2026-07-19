package exercicios19072026parte1;

import java.util.Scanner;

public class Ex10Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex10 ex10 = new Ex10();

        System.out.print("Digite o valor em Reais (R$): ");
        double valorReais = sc.nextDouble();

        System.out.print("Digite a cotação do dólar: ");
        double cotacaoDolar = sc.nextDouble();

        ex10.setValorReais(valorReais);
        ex10.setCotacaoDolar(cotacaoDolar);

        System.out.printf("Valor em dólares: US$ %.2f%n", ex10.getValorDolar());

        System.out.println(ex10);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}