package exercicios19072026parte1;

import java.util.Scanner;

public class Ex08Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex08 ex08 = new Ex08();

        System.out.print("Digite o salário fixo: R$ ");
        double salarioFixo = sc.nextDouble();

        System.out.print("Digite o valor vendido no mês: R$ ");
        double valorVendas = sc.nextDouble();

        ex08.setSalarioFixo(salarioFixo);
        ex08.setValorVendas(valorVendas);

        System.out.printf("Comissão: R$ %.2f%n", ex08.getComissao());
        System.out.printf("Salário final: R$ %.2f%n", ex08.getSalarioFinal());

        System.out.println(ex08);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}