package exercicios23102026parte0.oo.exercicio1;

public class Guerreiro extends Personagem {

    public Guerreiro(Long id, String nome) {
        super(id, nome, 150, 1, 15, 10);
    }

    @Override
    public int atacar(Entidade alvo) {
        int dano = calcularDanoComArma();
        alvo.receberDano(dano);

        System.out.printf(
                "%s golpeou %s e causou %d de dano.%n",
                getNome(), alvo.getNome(), dano
        );

        return dano;
    }
}