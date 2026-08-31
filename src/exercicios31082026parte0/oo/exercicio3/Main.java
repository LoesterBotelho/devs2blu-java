package exercicios31082026parte0.oo.exercicio3;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static int totalErros = 0;
    private static int totalDivisoes = 0;
    private static int totalConversoes = 0;
    private static int totalSaques = 0;

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria(1000.0);

        int opcao = 0;

        do {

            System.out.println();
            System.out.println(" MENU : ");
            System.out.println("1 - Dividir números");
            System.out.println("2 - Converter texto para inteiro");
            System.out.println("3 - Acessar posição do vetor");
            System.out.println("4 - Calcular tamanho de String");
            System.out.println("5 - Sacar dinheiro");
            System.out.println("6 - Abrir arquivo");
            System.out.println("7 - Lançar IllegalArgumentException");
            System.out.println("8 - Lançar RuntimeException");
            System.out.println("9 - Throw manual");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        dividir();
                        break;

                    case 2:
                        converterNumero();
                        break;

                    case 3:
                        acessarVetor();
                        break;

                    case 4:
                        tamanhoString();
                        break;

                    case 5:
                        sacar(conta);
                        break;

                    case 6:
                        abrirArquivoMenu();
                        break;

                    case 7:
                        testarIllegalArgument();
                        break;

                    case 8:
                        testarRuntime();
                        break;

                    case 9:
                        testarThrowManual();
                        break;

                    case 0:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");

                }

            } catch (NumberFormatException e) {

                totalErros++;
                System.out.println("Digite apenas números.");

            } catch (Exception e) {

                totalErros++;
                System.out.println("Erro inesperado: " + e.getMessage());

            } finally {

                System.out.println("Operação finalizada.");

            }

        } while (opcao != 0);

        System.out.println();
        System.out.println("--------- RESUMO ---------");
        System.out.println("Divisões: " + totalDivisoes);
        System.out.println("Conversões: " + totalConversoes);
        System.out.println("Saques: " + totalSaques);
        System.out.println("Total de erros: " + totalErros);

        scanner.close();
    }

    private static void dividir() {

        try {

            System.out.print("Primeiro número: ");
            double a = Double.parseDouble(scanner.nextLine());

            System.out.print("Segundo número: ");
            double b = Double.parseDouble(scanner.nextLine());

            double resultado = a / b;

            if (b == 0) {
                throw new ArithmeticException("Divisão por zero.");
            }

            System.out.println("Resultado = " + resultado);
            totalDivisoes++;

        } catch (ArithmeticException e) {

            totalErros++;
            System.out.println(e.getMessage());

        } finally {

            System.out.println("Fim da divisão.");

        }

    }

    private static void converterNumero() {

        try {

            System.out.print("Digite um número: ");

            int numero = Integer.parseInt(scanner.nextLine());

            System.out.println("Número = " + numero);

            totalConversoes++;

        } catch (NumberFormatException e) {

            totalErros++;
            System.out.println("Número inválido.");

        }

    }

    private static void acessarVetor() {

        int[] vetor = {10,20,30,40,50};

        try {

            System.out.print("Índice: ");

            int indice = Integer.parseInt(scanner.nextLine());

            System.out.println(vetor[indice]);

        } catch (ArrayIndexOutOfBoundsException e) {

            totalErros++;
            System.out.println("Índice inexistente.");

        }

    }

    private static void tamanhoString() {

        try {

            System.out.print("Digite um texto (ENTER vazio gera Null): ");

            String texto = scanner.nextLine();

            if (texto.isBlank()) {
                texto = null;
            }

            System.out.println(texto.length());

        } catch (NullPointerException e) {

            totalErros++;
            System.out.println("Texto nulo.");

        }

    }

    private static void sacar(ContaBancaria conta) {

        try {

            System.out.println("Saldo = " + conta.getSaldo());

            System.out.print("Valor saque: ");

            double valor = Double.parseDouble(scanner.nextLine());

            conta.sacar(valor);

            totalSaques++;

            System.out.println("Novo saldo = " + conta.getSaldo());

        } catch (SaldoInsuficienteException e) {

            totalErros++;
            System.out.println(e.getMessage());

        }

    }

    private static void abrirArquivoMenu() {

        try {

            System.out.print("Nome do arquivo: ");

            String nome = scanner.nextLine();

            abrirArquivo(nome);

        } catch (IOException e) {

            totalErros++;
            System.out.println(e.getMessage());

        }

    }

    public static void abrirArquivo(String nome) throws IOException {

        throw new IOException("Arquivo '" + nome + "' não encontrado.");

    }

    private static void testarIllegalArgument() {

        try {

            System.out.print("Digite uma idade: ");

            int idade = Integer.parseInt(scanner.nextLine());

            if (idade < 0) {
                throw new IllegalArgumentException("Idade negativa.");
            }

            System.out.println("Idade válida.");

        } catch (IllegalArgumentException e) {

            totalErros++;
            System.out.println(e.getMessage());

        }

    }

    private static void testarRuntime() {

        try {

            throw new RuntimeException("Erro de Runtime.");

        } catch (RuntimeException e) {

            totalErros++;
            System.out.println(e.getMessage());

        }

    }

    private static void testarThrowManual() {

        try {

            System.out.print("Digite SIM para continuar: ");

            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("SIM")) {

                throw new Exception("Resposta inválida.");

            }

            System.out.println("Operação aceita.");

        } catch (Exception e) {

            totalErros++;
            System.out.println(e.getMessage());

        }

    }

}