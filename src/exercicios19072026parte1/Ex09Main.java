package exercicios19072026parte1;

import java.util.Scanner;

public class Ex09Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex09 ex09 = new Ex09();

        System.out.print("Digite o valor da compra: R$ ");
        double valorCompra = sc.nextDouble();

        System.out.print("Digite o número de parcelas: ");
        int numeroParcelas = sc.nextInt();

        System.out.print("Digite a taxa de juros (%). Digite 0 para sem juros: ");
        double juros = sc.nextDouble();

        ex09.setValorCompra(valorCompra);
        ex09.setNumeroParcelas(numeroParcelas);
        ex09.setJuros(juros);

        if (juros == 0) {
            System.out.println("\nCompra sem juros.");
        } else {
            System.out.printf("\nCompra com %.2f%% de juros.%n", juros);
        }

        System.out.printf("Valor de cada parcela: R$ %.2f%n", ex09.getValorParcela());

        System.out.println(ex09);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}
