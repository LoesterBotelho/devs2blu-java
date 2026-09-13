package exercicios12092026parte0.oo.exercicio2;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Ranking<T extends Pontuavel> {
    
    List<T> ordenarPorPontuacao(List<T> itens);

    Optional<T> maiorPontuacao(List<T> itens);

    List<T> filtrar(List<T> itens, Predicate<T> criterio);
}