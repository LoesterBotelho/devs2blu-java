package exercicios28092026parte0.oo.exercicio4;

public class Vendedor {

    private final Long id;
    private final String nome;
    private final Regiao regiao;

    public Vendedor(
            Long id,
            String nome,
            Regiao regiao) {

        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", regiao=" + regiao +
                '}';
    }
}