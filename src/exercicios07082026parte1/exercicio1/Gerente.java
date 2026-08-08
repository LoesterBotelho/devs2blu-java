package exercicios07082026parte1.exercicio1;

public class Gerente extends Funcionario {

    private String departamento;

    public Gerente(
            String nome,
            String cpf,
            double salario,
            String departamento) {

        super(nome, cpf, salario);

        this.departamento = departamento;
    }

    @Override
    public void trabalhar() {

        System.out.println(
                getNome()
                + " está gerenciando o departamento "
                + departamento);
    }

    public String getDepartamento() {
        return departamento;
    }

	@Override
	public String toString() {
		return "Gerente [departamento=" + departamento + 
				"]";
	}

}