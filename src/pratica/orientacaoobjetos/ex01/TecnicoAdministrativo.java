package pratica.orientacaoobjetos.ex01;

import java.time.LocalDate;

public class TecnicoAdministrativo extends Funcionario {

	private String cargo;

	private String departamento;

	public TecnicoAdministrativo(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, Endereco endereco,
			String ctps, double salario, String cargo, String departamento) {

		super(nome, cpf, dataNascimento, sexo, endereco, ctps, salario);

		this.cargo = validarCampo(cargo, "Cargo");

		this.departamento = validarCampo(departamento, "Departamento");

	}

	public void alterarDepartamento(String departamento) {

		this.departamento = validarCampo(departamento, "Departamento");

	}

	private String validarCampo(String valor, String nomeCampo) {

		if (valor == null || valor.isBlank()) {

			throw new IllegalArgumentException(nomeCampo + " obrigatório");

		}

		return valor;

	}

	public String getCargo() {

		return cargo;

	}

	public String getDepartamento() {

		return departamento;

	}

}