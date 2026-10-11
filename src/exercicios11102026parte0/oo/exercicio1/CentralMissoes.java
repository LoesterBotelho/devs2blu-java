package exercicios11102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class CentralMissoes<T extends Missao> {

	private final List<T> missoes = new ArrayList<>();

    public void adicionar(T missao) {
        missoes.add(missao);
    }

    public List<T> listar() {
        return List.copyOf(missoes);
    }

    public List<T> buscarPorDuracao(int duracaoMaxima) {
        return missoes.stream()
                .filter(missao -> missao.getDuracaoDias() <= duracaoMaxima)
                .toList();
    }

    public void executarMissoes() {
        missoes.forEach(missao -> System.out.println(missao.executar()));
    }

    public int quantidade() {
        return missoes.size();
    }
    
}