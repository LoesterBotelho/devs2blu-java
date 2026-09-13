package exercicios12092026parte0.oo.exercicio2;

public record Jogo(String id, String nome, double pontuacao)
        implements Identifiable<String>, Pontuavel {

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getPontuacao() {
        return pontuacao;
    }

}