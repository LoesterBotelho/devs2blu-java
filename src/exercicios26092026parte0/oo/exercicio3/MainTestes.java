package exercicios26092026parte0.oo.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

        List<String> linguagens =
                new ArrayList<>(
                        List.of(
                                "Java",
                                "Python",
                                "TypeScript",
                                "C++"
                        )
                );

        linguagens.sort(
                (linguagem1, linguagem2) ->
                        Integer.compare(
                                linguagem1.length(),
                                linguagem2.length()
                        )
        );

        FiltroAvancado.imprimirItens(linguagens);
    }
}