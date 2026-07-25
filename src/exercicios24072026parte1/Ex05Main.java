package exercicios24072026parte1;

import java.util.Scanner;

public class Ex05Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numeroCarteira;
        int qtdMultas;
        int maiorQtdMultas = -1;
        int carteiraMaiorMultas = 0;

        double valorMulta;
        double dividaMotorista;
        double totalArrecadado = 0;

        while (true) {

            System.out.print("\nDigite 0 para encerrar");
            System.out.print("Número da carteira : ");
            numeroCarteira = sc.nextInt();

            if (numeroCarteira == 0) {
                break;
            }

            System.out.print("Quantidade de multas : ");
            qtdMultas = sc.nextInt();

            dividaMotorista = 0;

            for (int i = 1; i <= qtdMultas; i++) {

                System.out.print("Valor da multa " + i + ": R$ ");
                valorMulta = sc.nextDouble();

                dividaMotorista += valorMulta;
            }

            System.out.printf("Dívida do motorista: R$ %.2f%n", dividaMotorista);

            totalArrecadado += dividaMotorista;

            if (qtdMultas > maiorQtdMultas) {
                maiorQtdMultas = qtdMultas;
                carteiraMaiorMultas = numeroCarteira;
            }
        }

        System.out.println("\n Saida : ");
        System.out.printf("Total arrecadado: R$ %.2f%n", totalArrecadado);

        if (maiorQtdMultas >= 0) {
            System.out.println("Carteira com maior número de multas: " + carteiraMaiorMultas);
            System.out.println("Quantidade de multas: " + maiorQtdMultas);
        } else {
            System.out.println("Nenhum motorista foi cadastrado.");
        }

        sc.close();
    }
}