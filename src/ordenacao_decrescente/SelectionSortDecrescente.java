package ordenacao_decrescente;

public class SelectionSortDecrescente {


    public static void ordenar(int[] numeros) {


        for (int i = 0; i < numeros.length - 1; i++) {


            int maior = i;


            for (int j = i + 1; j < numeros.length; j++) {


                if (numeros[j] > numeros[maior]) {

                    maior = j;
                }
            }


            int temp = numeros[i];

            numeros[i] = numeros[maior];

            numeros[maior] = temp;
        }
    }
}