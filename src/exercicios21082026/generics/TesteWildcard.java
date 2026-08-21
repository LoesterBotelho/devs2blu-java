package exercicios21082026.generics;

import java.util.List;

public class TesteWildcard {

    // Lê elementos de uma lista de qualquer coisa que seja Number ou subclasse
    public static void somarLista(List<? extends Number> lista) {
        double soma = 0.0;
        for (Number n : lista) {
            soma += n.doubleValue();
        }
        System.out.println("Soma: " + soma);
    }

    // Adiciona elementos em uma lista de Integer ou superclasses (ex: Number, Object)
    public static void adicionarInteiros(List<? super Integer> lista) {
        lista.add(10);
        lista.add(20);
    }
}