package exercicios22102026parte0.oo.exercicio1;

public class Pessoa implements Identificavel {

    private final Long id;
    private String nome;

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{id=%d, nome='%s'}".formatted(id, nome);
    }
}