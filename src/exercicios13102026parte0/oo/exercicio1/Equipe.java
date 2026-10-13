package exercicios13102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Equipe implements Pontuavel {
	
    private final String nome;
    private final List<Jogador> jogadores = new ArrayList<>();
    private int pontos;

    public Equipe(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getPontos() {
        return pontos;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public List<Jogador> getJogadores() {
        return List.copyOf(jogadores);
    }

    public void registrarVitoria() {
        pontos += 3;
    }

    public void registrarEmpate() {
        pontos++;
    }

    @Override
    public String toString() {
        return nome + " - " + pontos + " pontos";
    }
    
}