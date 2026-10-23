package exercicios23102026parte0.oo.exercicio1;

public class Arma extends Item {

    private final int dano;

    public Arma(
            Long id, String nome, Raridade raridade,
            int valor, int dano) {
        super(id, nome, TipoItem.ARMA, raridade, valor);

        if (dano < 0) {
            throw new IllegalArgumentException(
                    "O dano não pode ser negativo");
        }

        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", dano=" + dano;
    }
}