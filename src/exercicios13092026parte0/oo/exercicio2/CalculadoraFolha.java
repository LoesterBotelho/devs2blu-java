package exercicios13092026parte0.oo.exercicio2;

import java.util.List;

public class CalculadoraFolha {

    public static <T extends Calculavel> double calcularTotal(
            List<T> itens) {

        return itens.stream()
                .mapToDouble(Calculavel::calcular)
                .sum();
    }

}