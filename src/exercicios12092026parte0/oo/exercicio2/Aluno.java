package exercicios12092026parte0.oo.exercicio2;

public record Aluno(Long id, String nome, double nota)
        implements Identifiable<Long>, Pontuavel {

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public double getPontuacao() {
        return nota;
    }

}