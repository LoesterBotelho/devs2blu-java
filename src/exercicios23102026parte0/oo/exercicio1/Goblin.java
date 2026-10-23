package exercicios23102026parte0.oo.exercicio1;

public class Goblin extends Monstro {

    public Goblin(Long id, String nome) {
        super(id, nome, 45, 7, 30);
    }

    @Override
    public int atacar(Entidade alvo) {
        int dano = getForca();
        alvo.receberDano(dano);

        System.out.printf(
                "Goblin %s atacou %s e causou %d de dano.%n",
                getNome(), alvo.getNome(), dano
        );

        return dano;
    }
}