package exercicios11102026parte0.oo.exercicio1;

public class MissaoExploracao extends Missao {
	
    private final String planeta;

    public MissaoExploracao(String nome, int duracaoDias, String planeta) {
        super(nome, duracaoDias);
        this.planeta = planeta;
    }

    public String getPlaneta() {
        return planeta;
    }

    @Override
    public String executar() {
        return "Explorando o planeta " + planeta;
    }

    @Override
    public String toString() {
        return super.toString() + " - Planeta: " + planeta;
    }
    
}