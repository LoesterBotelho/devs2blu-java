package exercicios23102026parte0.oo.exercicio1;

public class Mago extends Personagem {

    public Mago(Long id, String nome) {
        super(id, nome, 90, 1, 8, 40);
    }

    @Override
    public int atacar(Entidade alvo) {
        int dano;

        if (gastarMana(10)) {
            dano = 25 + getNivel() * 3;
            System.out.println(getNome() + " lançou uma magia!");
        } else {
            dano = Math.max(1, getForca());
            System.out.println(getNome() + " usou um ataque básico.");
        }

        alvo.receberDano(dano);

        System.out.printf(
                "%s causou %d de dano em %s.%n",
                getNome(), dano, alvo.getNome()
        );

        return dano;
    }
}