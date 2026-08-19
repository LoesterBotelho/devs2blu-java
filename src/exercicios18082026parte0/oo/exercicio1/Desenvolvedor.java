package exercicios18082026parte0.oo.exercicio1;

public class Desenvolvedor extends Funcionario {
    private int horasExtras;

    public Desenvolvedor() {
        super();
        this.horasExtras = 0;
    }

    public Desenvolvedor(String nome, double salarioBase, int horasExtras) {
        super(nome, salarioBase);
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSalario() {
        return this.salarioBase + (this.horasExtras * 50.0);
    }

    @Override
    public String toString() {
        return super.toString() + " [Cargo: Desenvolvedor]";
    }
}