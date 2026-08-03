package pratica.orientacaoobjetos.ex01;

import java.time.LocalDate;

public abstract class Funcionario extends Pessoa {

	private final String ctps;

	private double salario;

	protected Funcionario(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, Endereco endereco, String ctps,
			double salario) {

		super(nome, cpf, dataNascimento, sexo, endereco);

		if (ctps == null || ctps.isBlank()) {

			throw new IllegalArgumentException("CTPS obrigatória");
		}

		if (salario < 0) {

			throw new IllegalArgumentException("Salário inválido");
		}

		this.ctps = ctps;

		this.salario = salario;

	}

	public void aumentarSalario(double percentual) {

		if (percentual <= 0) {

			throw new IllegalArgumentException("Percentual deve ser maior que zero");
		}

		salario += salario * percentual / 100;

	}

	public double getSalario() {

		return salario;

	}

	public String getCtps() {

		return ctps;

	}

}