package exercicios11102026parte0.oo.exercicio1;

public abstract class Missao {
	
    private final String nome;
    private final int duracaoDias;

    protected Missao(String nome, int duracaoDias) {
        this.nome = nome;
        this.duracaoDias = duracaoDias;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public abstract String executar();

    @Override
    public String toString() {
        return nome + " - " + duracaoDias + " dias";
    }
    
}