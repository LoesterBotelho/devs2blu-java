package exercicios07082026parte1.exercicio1;

public abstract class Funcionario extends Pessoa {

    private double salario;

    public Funcionario(
            String nome,
            String cpf,
            double salario) {

        super(nome, cpf);
        this.salario = salario;
    }

    public abstract void trabalhar();

    public void aumentarSalario(double percentual) {

        salario += salario * percentual / 100;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void apresentar() {

        super.apresentar();

        System.out.println(
                "Salário: R$ " + salario);
    }

	@Override
	public String toString() {
		return "Funcionario [salario=" + salario + 
				"]";
	}
    
    
}