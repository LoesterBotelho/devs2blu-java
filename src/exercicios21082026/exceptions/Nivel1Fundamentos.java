package exercicios21082026.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Nivel1Fundamentos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            System.err.println("Erro: Você deve digitar apenas números inteiros válidos.");
        } finally {
            System.out.println("Operação finalizada.");
            scanner.close();
        }
    }
}
