package exercicios24072026.explicacao;

import java.util.Scanner;

public class WhileTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num = scanner.nextInt();

        while (num > 0) {
            System.out.println("Número: " + num);
            num--;
        }

        scanner.close();
    }
}