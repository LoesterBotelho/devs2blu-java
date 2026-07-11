package exemplos;
/**
 * Classe demonstrando:
 * - if
 * - else if
 * - else
 * - operador ternário
 * - for
 * - while
 * - do while
 */
public class EstruturasControle {

    public static void main(String[] args) {

        System.out.println("===== IF / ELSE IF / ELSE =====");

        int nota = 75;

        if (nota >= 90) {
            System.out.println("Conceito A");
        } else if (nota >= 70) {
            System.out.println("Conceito B");
        } else if (nota >= 60) {
            System.out.println("Conceito C");
        } else {
            System.out.println("Reprovado");
        }

        System.out.println("\n===== OPERADOR TERNÁRIO =====");

        int idade = 20;

        String status = idade >= 18
                ? "Maior de idade"
                : "Menor de idade";

        System.out.println("Status: " + status);

        System.out.println("\n===== FOR =====");

        /*
         * Executa de 1 até 5
         */
        for (int i = 1; i <= 5; i++) {
            System.out.println("For -> " + i);
        }

        System.out.println("\n===== WHILE =====");

        /*
         * Executa enquanto a condição for verdadeira
         */
        int contador = 1;

        while (contador <= 5) {
            System.out.println("While -> " + contador);
            contador++;
        }

        System.out.println("\n===== DO WHILE =====");

        /*
         * O bloco é executado pelo menos uma vez
         */
        int numero = 1;

        do {
            System.out.println("Do While -> " + numero);
            numero++;
        } while (numero <= 5);

        System.out.println("\n===== EXEMPLO COMPLETO =====");

        int valor = 8;

        // Operador ternário
        String resultado = valor % 2 == 0
                ? "Par"
                : "Ímpar";

        System.out.println("O número " + valor + " é " + resultado);

        // if/else
        if (valor > 10) {
            System.out.println("Maior que 10");
        } else {
            System.out.println("Menor ou igual a 10");
        }
    }
}