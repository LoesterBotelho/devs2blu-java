package exercicios22072026parte1;

import java.util.Scanner;

public class Ex08Main {

    public static void main(String[] args) {

        getAuthor();

        Scanner sc = new Scanner(System.in);

        Ex08 ex08 = new Ex08();

        System.out.print("Digite o valor do produto: R$ ");
        ex08.setValorProduto(sc.nextDouble());

        sc.nextLine(); // Limpa o buffer

        System.out.print("Forma de pagamento (dinheiro ou cheque) : ");
        ex08.setFormaPagamento(sc.nextLine());

        System.out.println("\n RESULTADO");

        System.out.printf("Valor do Produto : R$ %.2f%n", ex08.getValorProduto());
        System.out.println("Forma de Pagamento : " + ex08.getFormaPagamento());
        System.out.printf("Desconto : R$ %.2f%n", + ex08.getDesconto());
        System.out.printf("Valor Final : R$ %.2f%n", ex08.getValorFinal());

        System.out.println("\n" + ex08);

        sc.close();
    }

    public static void getAuthor() {
        System.out.println("---------------------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------------------\n");
    }

}