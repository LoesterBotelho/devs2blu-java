package poo.exercicio02;

public class Funcionario extends Pessoa {

    private String cargo;

    public Funcionario(String nome, int idade, String cargo) {
        super(nome, idade);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void apresentar() {
        System.out.println("Funcionário: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Cargo: " + cargo);
    }

    public void trabalhar() {
        System.out.println(getNome() + " está trabalhando.");
    }
}