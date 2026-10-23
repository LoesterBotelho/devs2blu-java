package exercicios22102026parte0.oo.exercicio1;

public class Desenvolvedor extends Pessoa {

    private String linguagemPrincipal;

    public Desenvolvedor(
            Long id, String nome, String linguagemPrincipal) {
        super(id, nome);
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    public void setLinguagemPrincipal(String linguagemPrincipal) {
        this.linguagemPrincipal = linguagemPrincipal;
    }

    @Override
    public String toString() {
        return "Desenvolvedor{id=%d, nome='%s', linguagem='%s'}"
                .formatted(getId(), getNome(), linguagemPrincipal);
    }
}