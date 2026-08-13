package exercicios13082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leitor {

	private static int contadorId = 1;

	private int id;
	private String nome;
	private String email;
	private String telefone;
	private List<Emprestimo> listaEmprestimos;
	private boolean leitorAsseduo;

	public Leitor() {
		this.id = contadorId++;
		this.listaEmprestimos = new ArrayList<>();
		this.leitorAsseduo = false;
	}

	public Leitor(String nome, String email, String telefone) {
		this();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public void adicionarEmprestimo(Emprestimo emprestimo) {
		this.listaEmprestimos.add(emprestimo);
		if (this.listaEmprestimos.size() >= 3) {
			this.leitorAsseduo = true;
		}
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Emprestimo> getListaEmprestimos() {
		return listaEmprestimos;
	}

	public boolean isLeitorAsseduo() {
		return leitorAsseduo;
	}

	@Override
	public String toString() {
		return "Leitor [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", asseduo="
				+ leitorAsseduo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Leitor other = (Leitor) obj;
		return id == other.id;
	}
}