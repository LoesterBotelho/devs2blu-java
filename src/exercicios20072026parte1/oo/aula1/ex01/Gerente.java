package exercicios20072026parte1.oo.aula1.ex01;

public final class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.25;
    }

    @Override
    public void exibirCargo() {
        System.out.println("Cargo: Gerente");
    }

}