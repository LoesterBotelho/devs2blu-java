package exercicios11102026parte0.oo.exercicio1;

public class MissaoPesquisa extends Missao {

	private final String areaCientifica;

    public MissaoPesquisa(String nome, int duracaoDias, String areaCientifica) {
        super(nome, duracaoDias);
        this.areaCientifica = areaCientifica;
    }

    public String getAreaCientifica() {
        return areaCientifica;
    }

    @Override
    public String executar() {
        return "Realizando pesquisas em " + areaCientifica;
    }

    @Override
    public String toString() {
        return super.toString() + " - Área: " + areaCientifica;
    }
    
}