package exercicios23102026parte0.oo.exercicio1;

public class Batalha {

    public ResultadoBatalha lutar(
            Personagem personagem, Monstro monstro) {

        int rodadas = 0;

        System.out.println("\nBATALHA INICIADA");
        System.out.println(personagem);
        System.out.println(monstro);

        while (personagem.estaViva() && monstro.estaViva()) {
            rodadas++;

            System.out.println("\nRodada " + rodadas);

            personagem.atacar(monstro);

            if (monstro.estaViva()) {
                monstro.atacar(personagem);
            }
        }

        boolean venceu = personagem.estaViva();

        if (venceu) {
            personagem.ganharExperiencia(
                    monstro.getExperienciaRecompensa()
            );

            System.out.println(
                    personagem.getNome() + " venceu a batalha!"
            );
        } else {
            System.out.println(
                    personagem.getNome() + " foi derrotado."
            );
        }

        return new ResultadoBatalha(
                venceu ? personagem.getNome() : monstro.getNome(),
                rodadas,
                venceu
        );
    }
}