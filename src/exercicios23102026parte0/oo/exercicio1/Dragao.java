package exercicios23102026parte0.oo.exercicio1;

public class Dragao extends Monstro {

    public Dragao(Long id, String nome) {
        super(id, nome, 200, 20, 250);
    }

    @Override
    public int atacar(Entidade alvo) {
        int dano = getForca() + 10;
        alvo.receberDano(dano);

        System.out.printf(
                "Dragão %s lançou fogo contra %s: %d de dano.%n",
                getNome(), alvo.getNome(), dano
        );

        return dano;
    }
}