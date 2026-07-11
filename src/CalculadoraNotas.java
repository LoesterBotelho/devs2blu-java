import java.util.Arrays;
import java.util.Scanner;

/**
 * Programa que lê 4 notas e calcula:
 * 1. Média Aritmética
 * 2. Média Ponderada
 * 3. Mediana
 */
public class CalculadoraNotas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Vetor para armazenar as 4 notas
        double[] notas = new double[4];

        System.out.println("=== SISTEMA DE CÁLCULO DE NOTAS ===");

        // Leitura das notas
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a " + (i + 1) + "ª nota: ");
            notas[i] = scanner.nextDouble();
        }

        /*
         * ==========================
         * MÉDIA ARITMÉTICA
         * ==========================
         * Soma todas as notas e divide pela quantidade.
         */
        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        double mediaAritmetica = soma / notas.length;

        /*
         * ==========================
         * MÉDIA PONDERADA
         * ==========================
         * Pesos: 1, 2, 3 e 4
         */
        int[] pesos = {1, 2, 3, 4};

        double somaPonderada = 0;
        int somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            somaPonderada += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }

        double mediaPonderada = somaPonderada / somaPesos;

        /*
         * ==========================
         * MEDIANA
         * ==========================
         * Ordena as notas e pega a média
         * dos dois valores centrais.
         */
        double[] notasOrdenadas = notas.clone();

        Arrays.sort(notasOrdenadas);

        double mediana = (notasOrdenadas[1] + notasOrdenadas[2]) / 2;

        /*
         * ==========================
         * RESULTADOS
         * ==========================
         */
        System.out.println("\n===== RESULTADOS =====");

        System.out.println("Média Aritmética: "
                + String.format("%.2f", mediaAritmetica));

        System.out.println("Média Ponderada: "
                + String.format("%.2f", mediaPonderada));

        System.out.println("Mediana: "
                + String.format("%.2f", mediana));

        scanner.close();
    }
}