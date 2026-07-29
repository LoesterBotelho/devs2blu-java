package ordenacao_decrescente;


public class MainDecrescente {


    public static void main(String[] args) {


        int[] numeros1 = {5, 2, 8, 1, 3};


        System.out.println("Antes Bubble Sort Decrescente:");

        imprimir(numeros1);


        BubbleSortDecrescente.ordenar(numeros1);


        System.out.println("Depois Bubble Sort Decrescente:");

        imprimir(numeros1);




        int[] numeros2 = {9, 4, 7, 2, 6};


        System.out.println("\nAntes Selection Sort Decrescente:");

        imprimir(numeros2);


        SelectionSortDecrescente.ordenar(numeros2);


        System.out.println("Depois Selection Sort Decrescente:");

        imprimir(numeros2);




        int[] numeros3 = {10, 3, 8, 1, 5};


        System.out.println("\nAntes Insertion Sort Decrescente:");

        imprimir(numeros3);


        InsertionSortDecrescente.ordenar(numeros3);


        System.out.println("Depois Insertion Sort Decrescente:");

        imprimir(numeros3);

    }



    private static void imprimir(int[] numeros) {


        for (int numero : numeros) {

            System.out.print(numero + " ");
        }

        System.out.println();
    }
}