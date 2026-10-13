package exercicios13102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Campeonato<T extends Pontuavel> {

	private final String nome;
    private final List<T> participantes = new ArrayList<>();

    public Campeonato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void inscrever(T participante) {
        participantes.add(participante);
    }

    public List<T> listarClassificacao() {
        return participantes.stream()
                .sorted(Comparator.comparingInt(Pontuavel::getPontos)
                        .reversed())
                .toList();
    }

    public Optional<T> buscarPorNome(String nome) {
        return participantes.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public Optional<T> getLider() {
        return listarClassificacao().stream().findFirst();
    }

    public int quantidadeParticipantes() {
        return participantes.size();
    }
    
}