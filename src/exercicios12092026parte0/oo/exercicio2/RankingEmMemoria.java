package exercicios12092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class RankingEmMemoria<T extends Pontuavel> implements Ranking<T> {

    @Override
    public List<T> ordenarPorPontuacao(List<T> itens) {
        List<T> resultado = new ArrayList<>(itens);

        resultado.sort(
                Comparator.comparingDouble(Pontuavel::getPontuacao)
                        .reversed()
        );

        return resultado;
    }

    @Override
    public Optional<T> maiorPontuacao(List<T> itens) {
        return itens.stream()
                .max(Comparator.comparingDouble(Pontuavel::getPontuacao));
    }

    @Override
    public List<T> filtrar(List<T> itens, Predicate<T> criterio) {
        return itens.stream()
                .filter(criterio)
                .toList();
    }

}