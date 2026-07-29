package ordenacao;

public class InsertionSort {

    public static void ordenar(int[] numeros) {

        for (int i = 1; i < numeros.length; i++) {

            int chave = numeros[i];

            int j = i - 1;


            while (j >= 0 && numeros[j] > chave) {

                numeros[j + 1] = numeros[j];

                j--;
            }

            numeros[j + 1] = chave;
        }
    }
}