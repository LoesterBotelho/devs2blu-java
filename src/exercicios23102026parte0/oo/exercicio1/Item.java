package exercicios23102026parte0.oo.exercicio1;

public abstract class Item implements Identificavel {

    private final Long id;
    private final String nome;
    private final TipoItem tipo;
    private final Raridade raridade;
    private final int valor;

    protected Item(
            Long id, String nome, TipoItem tipo,
            Raridade raridade, int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException(
                    "O valor não pode ser negativo");
        }

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.raridade = raridade;
        this.valor = valor;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "%s{nome='%s', raridade=%s, valor=%d}"
                .formatted(
                        getClass().getSimpleName(),
                        nome, raridade, valor
                );
    }
}