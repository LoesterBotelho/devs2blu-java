package exercicios26092026parte0.oo.exercicio3;

import java.util.List;

public final class FiltroAvancado {

    private FiltroAvancado() {
    }

    public static <T> void imprimirItens(List<T> itens) {
        itens.forEach(System.out::println);
    }
}