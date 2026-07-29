package ordenacao;

public class Main {

    public static void main(String[] args) {


        int[] numeros1 = {5, 2, 8, 1, 3};

        System.out.println("Antes Bubble Sort:");
        imprimir(numeros1);

        BubbleSort.ordenar(numeros1);

        System.out.println("Depois Bubble Sort:");
        imprimir(numeros1);



        int[] numeros2 = {9, 4, 7, 2, 6};

        System.out.println("\nAntes Selection Sort:");
        imprimir(numeros2);

        SelectionSort.ordenar(numeros2);

        System.out.println("Depois Selection Sort:");
        imprimir(numeros2);



        int[] numeros3 = {10, 3, 8, 1, 5};

        System.out.println("\nAntes Insertion Sort:");
        imprimir(numeros3);

        InsertionSort.ordenar(numeros3);

        System.out.println("Depois Insertion Sort:");
        imprimir(numeros3);

    }


    private static void imprimir(int[] numeros) {

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.println();
    }
}