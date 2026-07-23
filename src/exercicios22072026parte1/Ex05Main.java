package exercicios22072026parte1;

import java.util.Scanner;

public class Ex05Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex05 ex05 = new Ex05();

        System.out.print("Digite o valor da compra : R$ ");
        ex05.setValorCompra(sc.nextInt());

        System.out.print("Digite o valor do pagamento : R$ ");
        ex05.setValorPagamento(sc.nextInt());

        if (!ex05.isPagamentoValido()) {

            System.out.println("\nPagamento Negado");

        } else {

            System.out.println("\n TROCO");
            System.out.println("Valor da Compra : R$ " + ex05.getValorCompra());
            System.out.println("Valor Pago      : R$ " + ex05.getValorPagamento());
            System.out.println("Troco           : R$ " + ex05.getTroco());

            System.out.println("\nQuantidade de Notas");
            System.out.println("Notas de R$100: " + ex05.getNotas100());
            System.out.println("Notas de R$10 : " + ex05.getNotas10());
            System.out.println("Notas de R$1  : " + ex05.getNotas1());

            System.out.println("\n" + ex05.toString());
        }

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}