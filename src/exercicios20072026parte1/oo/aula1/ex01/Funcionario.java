package exercicios20072026parte1.oo.aula1.ex01;

public class Funcionario extends Pessoa implements Bonificacao {

    public Funcionario(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.10;
    }

    @Override
    public void exibirCargo() {
        System.out.println("Cargo: Funcionário");
    }

    @Override
    public String toString() {

        return "Funcionario [Nome=" + getNome()
                + ", Salário=" + getSalario()
                + ", Bônus=" + calcularBonus()
                + "]";
    }

}