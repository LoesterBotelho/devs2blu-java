package test;

public class Aluno {

    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    public Aluno(String nome, double nota1, double nota2,
                 double nota3, double nota4) {

        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public String getNome() {
        return nome;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    public String situacao() {

        if (calcularMedia() >= 7) {
            return "APROVADO";
        }

        return "REPROVADO";
    }
}