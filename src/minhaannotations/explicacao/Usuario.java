package minhaannotations.explicacao;

import java.time.LocalDate;
import java.util.Objects;

@Tabela(valor = "TB_TABELA")
public class Usuario {
	
	@Campo(valor = "NOME_COMPLETO")
	private String nome;
	
	@Campo(valor = "DOCUMENTO_CPF")	
	private String cpf;
	
	@Campo(valor = "DATA_NASCIMENTO")	
	@IdadeMinima(valor = 18)
	private LocalDate dataNascimento;

	public Usuario() {

	}

	public Usuario(String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + 
				", cpf=" + cpf + 
				", dataNascimento=" + dataNascimento + 
				"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

}