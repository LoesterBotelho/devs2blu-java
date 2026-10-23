package exercicios23102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EstatisticasRPG {

    private final List<Personagem> personagens;

    public EstatisticasRPG(List<Personagem> personagens) {
        this.personagens = List.copyOf(personagens);
    }

    public long total() {
        return personagens.size();
    }

    public long vivos() {
        return personagens.stream()
                .filter(Personagem::estaViva)
                .count();
    }

    public long derrotados() {
        return personagens.stream()
                .filter(personagem -> !personagem.estaViva())
                .count();
    }

    public double nivelMedio() {
        return personagens.stream()
                .mapToInt(Personagem::getNivel)
                .average()
                .orElse(0);
    }

    public Map<String, Long> contarPorClasse() {
        return personagens.stream()
                .collect(Collectors.groupingBy(
                        personagem -> personagem.getClass()
                                .getSimpleName(),
                        Collectors.counting()
                ));
    }

    public List<Personagem> ordenarPorNivel() {
        return personagens.stream()
                .sorted((a, b) ->
                        Integer.compare(b.getNivel(), a.getNivel()))
                .toList();
    }
}