package exercicios19082026parte0.oo.exercicio3;

public class Funcionario extends Pessoa {

    private String cargo;
    private double salario;
    private String setor;

    public Funcionario() {
    }

    public Funcionario(String nome, int idade, String cpf,
                       String cargo, double salario, String setor) {
        super(nome, idade, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.setor = setor;
    }

    @Override
    public void exibirDados() {
        System.out.println(this);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", cpf='" + getCpf() + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", setor='" + setor + '\'' +
                '}';
    }
}