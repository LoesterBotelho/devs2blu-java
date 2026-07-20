package exercicios20072026parte1.oo.aula1.ex01;

public abstract class Pessoa {

    private String nome;
    private double salario;

    public Pessoa(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método abstrato
    public abstract void exibirCargo();

}