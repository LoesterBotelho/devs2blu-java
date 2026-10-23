package exercicios23102026parte0.oo.exercicio1;

import java.util.function.Predicate;

public class Missao {

    private final String nome;
    private final String descricao;
    private final int recompensaExperiencia;
    private final Predicate<Personagem> objetivo;
    private boolean concluida;

    public Missao(
            String nome,
            String descricao,
            int recompensaExperiencia,
            Predicate<Personagem> objetivo) {

        if (recompensaExperiencia < 0) {
            throw new IllegalArgumentException(
                    "A recompensa não pode ser negativa");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.recompensaExperiencia = recompensaExperiencia;
        this.objetivo = objetivo;
    }

    public boolean tentarConcluir(Personagem personagem) {
        if (concluida || !objetivo.test(personagem)) {
            return false;
        }

        concluida = true;
        personagem.ganharExperiencia(recompensaExperiencia);

        System.out.println("Missão concluída: " + nome);

        return true;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }
}