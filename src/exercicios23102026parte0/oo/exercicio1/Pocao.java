package exercicios23102026parte0.oo.exercicio1;

public class Pocao extends Item {

    private final int cura;

    public Pocao(
            Long id, String nome, Raridade raridade,
            int valor, int cura) {
        super(id, nome, TipoItem.POCAO, raridade, valor);

        if (cura <= 0) {
            throw new IllegalArgumentException(
                    "A cura deve ser positiva");
        }

        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    public void usar(Personagem personagem) {
        personagem.curar(cura);

        System.out.printf(
                "%s usou %s e recuperou vida. Vida atual: %d/%d%n",
                personagem.getNome(), getNome(),
                personagem.getVida(), personagem.getVidaMaxima()
        );
    }
}