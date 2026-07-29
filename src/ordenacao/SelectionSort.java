package ordenacao;

public class SelectionSort {

    public static void ordenar(int[] numeros) {

        for (int i = 0; i < numeros.length - 1; i++) {

            int menor = i;

            for (int j = i + 1; j < numeros.length; j++) {

                if (numeros[j] < numeros[menor]) {
                    menor = j;
                }
            }

            int temp = numeros[i];
            numeros[i] = numeros[menor];
            numeros[menor] = temp;
        }
    }
}