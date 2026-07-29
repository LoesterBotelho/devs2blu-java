package ordenacao_decrescente;

public class BubbleSortDecrescente {

    public static void ordenar(int[] numeros) {

        for (int i = 0; i < numeros.length - 1; i++) {

            for (int j = 0; j < numeros.length - 1 - i; j++) {

                // Troca se o elemento da esquerda for menor
                if (numeros[j] < numeros[j + 1]) {

                    int temp = numeros[j];

                    numeros[j] = numeros[j + 1];

                    numeros[j + 1] = temp;
                }
            }
        }
    }
}