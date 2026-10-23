package exercicios22102026parte0.oo.exercicio1;

public class Projeto implements Identificavel {

    private final Long id;
    private String nome;
    private Desenvolvedor responsavel;

    public Projeto(Long id, String nome, Desenvolvedor responsavel) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Desenvolvedor getResponsavel() {
        return responsavel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setResponsavel(Desenvolvedor responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Projeto{id=%d, nome='%s'}".formatted(id, nome);
    }
}