package poo.exercicio02;

public class Aluno extends Pessoa {

    private String curso;

    public Aluno(String nome, int idade, String curso) {
        super(nome, idade);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void apresentar() {
        System.out.println("Aluno: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Curso: " + curso);
    }

    public void estudar() {
        System.out.println(getNome() + " está estudando.");
    }
}