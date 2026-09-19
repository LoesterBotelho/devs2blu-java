package exercicios18092026parte0.oo.exercicio2;

public class ValidadorUtilitarios {

    // Método genérico com Bounded Type Parameter
    public static <T extends Comparable<T>> T encontrarMaior(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T maior = array[0];
        for (int i = 1; i < array.length; i++) {
            // O método compareTo vem da interface Comparable
            if (array[i].compareTo(maior) > 0) {
                maior = array[i];
            }
        }
        return maior;
    }
}