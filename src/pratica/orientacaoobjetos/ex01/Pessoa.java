package pratica.orientacaoobjetos.ex01;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Pessoa {

	private String nome;

	private final String cpf;

	private String telefone;

	private String email;

	private final Sexo sexo;

	private final LocalDate dataNascimento;

	private final Endereco endereco;

	protected Pessoa(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, Endereco endereco) {

		this.nome = validarNome(nome);

		this.cpf = validarCpf(cpf);

		this.dataNascimento = Objects.requireNonNull(dataNascimento, "Data de nascimento obrigatória");

		if (dataNascimento.isAfter(LocalDate.now())) {

			throw new IllegalArgumentException("Data de nascimento inválida");
		}

		this.sexo = Objects.requireNonNull(sexo, "Sexo obrigatório");

		this.endereco = Objects.requireNonNull(endereco, "Endereço obrigatório");

	}

	public void atualizarTelefone(String telefone) {

		if (telefone == null || telefone.isBlank()) {

			throw new IllegalArgumentException("Telefone inválido");
		}

		this.telefone = telefone;

	}

	public void atualizarEmail(String email) {

		if (email == null || email.isBlank()) {

			throw new IllegalArgumentException("Email inválido");
		}

		this.email = email;

	}

	public int calcularIdade() {

		return Period.between(dataNascimento, LocalDate.now()).getYears();

	}

	private String validarNome(String nome) {

		if (nome == null || nome.isBlank()) {

			throw new IllegalArgumentException("Nome obrigatório");

		}

		return nome;

	}

	private String validarCpf(String cpf) {

		if (cpf == null || cpf.isBlank()) {

			throw new IllegalArgumentException("CPF obrigatório");

		}

		return cpf;

	}

	public String getNome() {

		return nome;

	}

	public String getCpf() {

		return cpf;

	}

	public String getTelefone() {

		return telefone;

	}

	public String getEmail() {

		return email;

	}

	public Sexo getSexo() {

		return sexo;

	}

	public LocalDate getDataNascimento() {

		return dataNascimento;

	}

	public Endereco getEndereco() {

		return endereco;

	}

	@Override
	public String toString() {

		return """
				Tipo: %s
				Nome: %s
				CPF: %s
				Idade: %d
				Sexo: %s
				Endereço: %s
				""".formatted(getClass().getSimpleName(), nome, cpf, calcularIdade(), sexo,
				endereco.obterEnderecoCompleto());

	}

}