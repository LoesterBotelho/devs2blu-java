package exercicios21082026.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("   SISTEMA DE DEMONSTRAÇÃO DE EXCEÇÕES");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Escolha o nível que deseja executar:");
        System.out.println("1 - Nível 1: Fundamentos (Divisão Segura)");
        System.out.println("2 - Nível 2: Exceção Customizada (Conta Bancária)");
        System.out.println("3 - Nível 3: Try-with-Resources (Conexão AutoCloseable)");
        System.out.println("4 - Nível 4: Exception Chaining (Pedido e Pagamento)");
        System.out.print("\nDigite a opção desejada (1-4): ");

        try {
            int opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    executarNivel1(scanner);
                    break;
                case 2:
                    executarNivel2();
                    break;
                case 3:
                    executarNivel3();
                    break;
                case 4:
                    executarNivel4();
                    break;
                default:
                    System.err.println("Opção inválida! Escolha um número entre 1 e 4.");
            }

        } catch (InputMismatchException e) {
            System.err.println("Erro: Você deve digitar um número inteiro válido para escolher a opção.");
        } finally {
            scanner.close();
            System.out.println("\n--- Execução da aplicação encerrada ---");
        }
    }

    private static void executarNivel1(Scanner scanner) {
        System.out.println("--- [Nível 1] Testando Divisão Segura ---");
        try {
            System.out.print("Digite o numerador (inteiro): ");
            int numerador = scanner.nextInt();

            System.out.print("Digite o denominador (inteiro): ");
            int denominador = scanner.nextInt();

            int resultado = numerador / denominador;
            System.out.println("Resultado da divisão: " + resultado);

        } catch (ArithmeticException e) {
            System.err.println("Erro: Não é possível dividir um número por zero!");
        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Digite apenas números inteiros.");
        } finally {
            System.out.println("Operação de divisão finalizada.");
        }
    }

    private static void executarNivel2() {
        System.out.println("--- [Nível 2] Testando Conta Bancária (Checked Exception) ---");
        ContaBancaria conta = new ContaBancaria(500.00);

        try {
            System.out.println("Saldo inicial: R$ 500.00");
            System.out.println("Tentando sacar R$ 600.00...");
            conta.sacar(600.00);
        } catch (SaldoInsuficienteException e) {
            System.err.println("Erro de Negócio: " + e.getMessage());
            System.err.println("Saldo atual disponível na conta: R$ " + e.getSaldoAtual());
        }
    }

    private static void executarNivel3() {
        System.out.println("--- [Nível 3] Testando Try-with-Resources ---");
        try (ConexaoBanco conexao = new ConexaoBanco()) {
            conexao.consultarDados();
        } catch (RuntimeException e) {
            System.err.println("Exceção capturada no fluxo principal: " + e.getMessage());
        }
    }

    private static void executarNivel4() {
        System.out.println("--- [Nível 4] Testando Exception Chaining ---");
        PedidoController controller = new PedidoController();

        try {
            controller.finalizarPedido();
        } catch (ProcessamentoPedidoException e) {
            System.err.println("Mensagem de Negócio: " + e.getMessage());
            System.err.println("--- Imprimindo o StackTrace completo (com a causa raiz) ---");
            e.printStackTrace();
        }
    }
}