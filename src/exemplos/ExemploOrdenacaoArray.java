package exemplos;

import java.util.Arrays;

/**
 * ==========================================================
 * ORDENAÇÃO DE ARRAYS
 * ==========================================================
 *
 * Arrays podem ser ordenados utilizando:
 *
 * Arrays.sort()
 *
 * Funciona para:
 * - int
 * - double
 * - String
 * - Objetos (com Comparator)
 *
 */
public class ExemploOrdenacaoArray {

    public static void main(String[] args) {

        String[] alunos = {
                "Carlos",
                "Ana",
                "Pedro",
                "Bruno",
                "Lucas"
        };

        System.out.println("Array Original");

        System.out.println(Arrays.toString(alunos));

        /*
         * Ordem alfabética (A-Z)
         */

        Arrays.sort(alunos);

        System.out.println("\nOrdem crescente");

        System.out.println(Arrays.toString(alunos));

        /*
         * Ordem decrescente
         */

        Arrays.sort(alunos, (a, b) -> b.compareTo(a));

        System.out.println("\nOrdem decrescente");

        System.out.println(Arrays.toString(alunos));

    }

}