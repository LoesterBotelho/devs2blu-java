package exercicios18082026parte0.oo.exercicio1;

public class Gerente extends Funcionario implements Autenticavel {
    private String senhaSistema;

    public Gerente() {
        super();
        this.senhaSistema = "1234";
    }

    public Gerente(String nome, double salarioBase, String senhaSistema) {
        super(nome, salarioBase);
        this.senhaSistema = senhaSistema;
    }

    @Override
    public double calcularSalario() {
        return this.salarioBase + 2000.0;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senhaSistema.equals(senha);
    }

    @Override
    public String toString() {
        return super.toString() + " [Cargo: Gerente]";
    }
}