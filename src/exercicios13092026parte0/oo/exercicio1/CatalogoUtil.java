package exercicios13092026parte0.oo.exercicio1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CatalogoUtil {

    public static double calcularValorTotal(
            List<? extends Precificavel> produtos) {

        return produtos.stream()
                .mapToDouble(Precificavel::getPreco)
                .sum();
    }

    public static <T> void adicionarTodos(
            List<? super T> destino,
            List<? extends T> origem) {

        destino.addAll(origem);
    }

    public static <T extends Precificavel> Optional<T> maiorPreco(
            List<T> produtos) {

        return produtos.stream()
                .max(Comparator.comparingDouble(Precificavel::getPreco));
    }

}