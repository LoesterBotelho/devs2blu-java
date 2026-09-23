package exercicios22092026parte0.oo.exercicio2;

public class Funcionario {

    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format(
                "Funcionario{nome='%s', cargo='%s', salario=R$ %.2f}",
                nome,
                cargo,
                salario
        );
    }
}