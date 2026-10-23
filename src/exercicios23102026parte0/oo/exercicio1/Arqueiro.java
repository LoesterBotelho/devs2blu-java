package exercicios23102026parte0.oo.exercicio1;

public class Arqueiro extends Personagem {

    public Arqueiro(Long id, String nome) {
        super(id, nome, 110, 1, 12, 20);
    }

    @Override
    public int atacar(Entidade alvo) {
        int dano = calcularDanoComArma() + 5;
        alvo.receberDano(dano);

        System.out.printf(
                "%s disparou uma flecha contra %s: %d de dano.%n",
                getNome(), alvo.getNome(), dano
        );

        return dano;
    }
}