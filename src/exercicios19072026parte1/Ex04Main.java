package exercicios19072026parte1;

import java.util.Scanner;

public class Ex04Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex04 ex12 = new Ex04();

        System.out.print("Digite o consumo de energia (kWh): ");
        double consumoKwh = sc.nextDouble();

        System.out.print("Digite o valor do kWh (R$): ");
        double valorKwh = sc.nextDouble();

        ex12.setConsumoKwh(consumoKwh);
        ex12.setValorKwh(valorKwh);

        System.out.printf("Valor da conta: R$ %.2f%n", ex12.getValorConta());
        System.out.printf("Imposto (12%%): R$ %.2f%n", ex12.getValorImposto());
        System.out.printf("Valor total a pagar: R$ %.2f%n", ex12.getValorTotal());

        System.out.println(ex12);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}