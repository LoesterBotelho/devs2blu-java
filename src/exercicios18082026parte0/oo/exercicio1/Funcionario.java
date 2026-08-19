package exercicios18082026parte0.oo.exercicio1;

public abstract class Funcionario extends EntidadeBase {
    private String nome;
    protected double salarioBase;

    public Funcionario() {
        super();
        this.nome = "Padrao";
        this.salarioBase = 0.0;
    }

    public Funcionario(String nome, double salarioBase) {
        this();
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public void registrarPonto() {
        System.out.println(nome + " registrou ponto.");
    }

    public void registrarPonto(String hora) {
        System.out.println(nome + " registrou ponto às " + hora + ".");
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return super.toString() + " - Nome: " + nome + 
        		", SalarioBase: " + salarioBase;
    }
}