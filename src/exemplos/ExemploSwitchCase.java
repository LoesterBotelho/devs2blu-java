package exemplos;

import java.util.Scanner;

/**
 * Exemplo de utilização do Switch Case em Java.
 *
 * O switch é utilizado quando precisamos executar
 * diferentes blocos de código com base em um valor.
 */
public class ExemploSwitchCase {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENU DE OPÇÕES ===");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Realizar Saque");
        System.out.println("3 - Realizar Depósito");
        System.out.println("4 - Sair");

        System.out.print("\nEscolha uma opção: ");
        int opcao = scanner.nextInt();

        /*
         * O switch avalia o valor da variável "opcao"
         * e executa o case correspondente.
         */
        switch (opcao) {

            case 1:
                System.out.println("Saldo atual: R$ 1.500,00");
                break;

            case 2:
                System.out.println("Saque realizado com sucesso!");
                break;

            case 3:
                System.out.println("Depósito realizado com sucesso!");
                break;

            case 4:
                System.out.println("Encerrando o sistema...");
                break;

            /*
             * Caso nenhum valor seja encontrado,
             * executa o bloco default.
             */
            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}