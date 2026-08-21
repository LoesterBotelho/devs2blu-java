package exercicios21082026.generics;

public class Utilitario {

    // Método genérico
    public static <T> void imprimirArray(T[] array) {
        for (T elemento : array) {
            System.out.println(elemento);
        }
    }
}