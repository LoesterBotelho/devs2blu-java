import java.util.Scanner;

public class CaixaEletronico {

    public record ResultadoSaque(
            boolean sucesso,
            int restante,
            int usar100,
            int usar50,
            int usar20,
            int usar10) {
    }

    // Notas disponíveis
    private int notas100 = 5;
    private int notas50 = 10;
    private int notas20 = 10;
    private int notas10 = 20;

    public static void main(String[] args) {
        CaixaEletronico caixa = new CaixaEletronico();
        caixa.iniciar();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    verificarEstoque();
                    break;

                case 2:
                    System.out.print("Digite o valor do saque: R$ ");
                    int valor = scanner.nextInt();
                    realizarSaque(valor);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n CAIXA");
        System.out.println("1 - Verificar Quantidade de Cédulas");
        System.out.println("2 - Realizar Saque");
        System.out.println("0 - Sair");
    }

    private void verificarEstoque() {
        int total = (notas100 * 100)
                + (notas50 * 50)
                + (notas20 * 20)
                + (notas10 * 10);

        System.out.println("\n QUANTIDADE DE CÉDULAS");
        System.out.println("Notas de R$100: " + notas100);
        System.out.println("Notas de R$50 : " + notas50);
        System.out.println("Notas de R$20 : " + notas20);
        System.out.println("Notas de R$10 : " + notas10);
        System.out.println("--------------------------------------------------------");
        System.out.println("Valor total disponível: R$ " + total);
    }

    private ResultadoSaque calcularSaque(int valor) {

        int restante = valor;

        int usar100 = Math.min(restante / 100, notas100);
        restante -= usar100 * 100;

        int usar50 = Math.min(restante / 50, notas50);
        restante -= usar50 * 50;

        int usar20 = Math.min(restante / 20, notas20);
        restante -= usar20 * 20;

        int usar10 = Math.min(restante / 10, notas10);
        restante -= usar10 * 10;

        return new ResultadoSaque(
                restante == 0,
                restante,
                usar100,
                usar50,
                usar20,
                usar10);
    }

    private void realizarSaque(int valor) {

        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        if (valor % 10 != 0) {
            System.out.println("O valor deve ser múltiplo de R$10.");
            return;
        }

        ResultadoSaque resultado = calcularSaque(valor);

        if (!resultado.sucesso()) {
            System.out.println("\nSaque recusado!");
            System.out.println(
                    "Não há cédulas suficientes para atender ao valor solicitado.");
            return;
        }

        // Atualiza o estoque somente após validar toda a operação.
        notas100 -= resultado.usar100();
        notas50 -= resultado.usar50();
        notas20 -= resultado.usar20();
        notas10 -= resultado.usar10();

        System.out.println("\n SAQUE REALIZADO");
        System.out.println("Valor sacado: R$ " + valor);

        if (resultado.usar100() > 0) {
            System.out.println("R$100 x " + resultado.usar100());
        }

        if (resultado.usar50() > 0) {
            System.out.println("R$50  x " + resultado.usar50());
        }

        if (resultado.usar20() > 0) {
            System.out.println("R$20  x " + resultado.usar20());
        }

        if (resultado.usar10() > 0) {
            System.out.println("R$10  x " + resultado.usar10());
        }

        System.out.println("Saque efetuado com sucesso!");
    }
}