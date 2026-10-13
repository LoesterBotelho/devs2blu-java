package exercicios13102026parte0.oo.exercicio1;

public class Jogador {

	private final String nome;
    private final String nickname;
    private final String jogo;

    public Jogador(String nome, String nickname, String jogo) {
        this.nome = nome;
        this.nickname = nickname;
        this.jogo = jogo;
    }

    public String getNome() {
        return nome;
    }

    public String getNickname() {
        return nickname;
    }

    public String getJogo() {
        return jogo;
    }

    @Override
    public String toString() {
        return nickname + " (" + nome + ") - " + jogo;
    }
    
}