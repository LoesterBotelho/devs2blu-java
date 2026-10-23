package exercicios23102026parte0.oo.exercicio1;

public abstract class Entidade implements Identificavel {

    private final Long id;
    private final String nome;
    private int vida;
    private final int vidaMaxima;

    protected Entidade(Long id, String nome, int vidaMaxima) {
        if (vidaMaxima <= 0) {
            throw new IllegalArgumentException(
                    "A vida máxima deve ser positiva");
        }

        this.id = id;
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public boolean estaViva() {
        return vida > 0;
    }

    public void receberDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException(
                    "O dano não pode ser negativo");
        }

        vida = Math.max(0, vida - dano);
    }

    public void curar(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException(
                    "A cura não pode ser negativa");
        }

        vida = Math.min(vidaMaxima, vida + quantidade);
    }

    public abstract int atacar(Entidade alvo);

    @Override
    public String toString() {
        return "%s{id=%d, nome='%s', vida=%d/%d}"
                .formatted(
                        getClass().getSimpleName(),
                        id, nome, vida, vidaMaxima
                );
    }
}