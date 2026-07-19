package exercicios19072026parte1;

import java.util.Scanner;

public class Ex05Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex05 ex05 = new Ex05();

        System.out.print("Digite o valor da hora trabalhada: R$ ");
        double valorHora = sc.nextDouble();

        System.out.print("Digite a quantidade de horas trabalhadas: ");
        double horasTrabalhadas = sc.nextDouble();

        System.out.print("Digite a quantidade de horas extras: ");
        double horasExtras = sc.nextDouble();

        ex05.setValorHora(valorHora);
        ex05.setHorasTrabalhadas(horasTrabalhadas);
        ex05.setHorasExtras(horasExtras);

        System.out.printf("Salário normal: R$ %.2f%n", ex05.getSalarioNormal());
        System.out.printf("Valor das horas extras: R$ %.2f%n", ex05.getValorHorasExtras());
        System.out.printf("Salário total: R$ %.2f%n", ex05.getSalarioTotal());

        System.out.println(ex05);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}