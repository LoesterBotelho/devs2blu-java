package exercicios30072026parte1.oo.classes;

public class TecnicoAdministrativo extends Funcionario {
	private String cargo;
	private String departamento;

	public TecnicoAdministrativo(String nome, String endereco, String telefone, String cpf, String numeroCtps,
			double salario, String cargo, String departamento) {
		super(nome, endereco, telefone, cpf, numeroCtps, salario);
		this.cargo = cargo;
		this.departamento = departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "TecnicoAdministrativo [cargo=" + cargo + ", departamento=" + departamento + "]";
	}

}