package exercicios27092026parte0.oo.exercicio1;

public class Cliente {

    private final Long id;
    private final String nome;
    private final String cidade;

    public Cliente(Long id, String nome, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return String.format(
                "Cliente{id=%d, nome='%s', cidade='%s'}",
                id,
                nome,
                cidade
        );
    }
}