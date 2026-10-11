package exercicios10102026parte0.oo.exercicio1;

public class Aluno extends Pessoa {
    private final String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + matricula;
    }
}