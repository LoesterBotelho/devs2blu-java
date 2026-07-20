package exercicios20072026parte1.oo.aula1.ex02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====== LOJA ======");
        System.out.println();

        System.out.println("1 - PIX");
        System.out.println("2 - CARTÃO");
        System.out.print("Escolha a forma de pagamento: ");

        int opcao = sc.nextInt();

        System.out.print("Digite o valor da compra: R$ ");
        double valor = sc.nextDouble();

        String tipoPagamento;

        switch (opcao) {

            case 1:
                tipoPagamento = "PIX";
                break;

            case 2:
                tipoPagamento = "CARTAO";
                break;

            default:
                System.out.println("Opção inválida.");
                sc.close();
                return;
        }

        Pagamento pagamento =
                PagamentoFactory.criar(tipoPagamento, valor);

        Pedido pedido = new Pedido(pagamento);

        pedido.finalizarPedido();

        System.out.println();
        System.out.println("========== RESUMO ==========");
        System.out.printf("Valor : R$ %.2f%n",
                pagamento.getValor());

        System.out.printf("Taxa  : R$ %.2f%n",
                pagamento.calcularTaxa());

        System.out.printf("Total : R$ %.2f%n",
                pagamento.calcularTotal());

        Notificacao.enviar(pagamento);

        sc.close();

    }

}