package poo.exercicio02;

public class Professor extends Pessoa {

    private String disciplina;

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public void apresentar() {
        System.out.println("Professor: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Disciplina: " + disciplina);
    }

    public void ensinar() {
        System.out.println(getNome() + " está ensinando.");
    }
}