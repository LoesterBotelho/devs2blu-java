package minhaannotations.exercicio1;

import java.util.Objects;

@MyClass( author="Loester Botelho", data = "2026-09-10" )
public class Desenvolvedor {
	private Integer id;
	private String nome;
	private String linguagem;
	private String nivel;

	public Desenvolvedor() {
	}

	public Desenvolvedor(Integer id, String nome, String linguagem, String nivel) {
		this.id = id;
		this.nome = nome;
		this.linguagem = linguagem;
		this.nivel = nivel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Desenvolvedor [id=" + id + 
				", nome=" + nome + 
				", linguagem=" + linguagem + 
				", nivel=" + nivel + 
				"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desenvolvedor other = (Desenvolvedor) obj;
		return Objects.equals(id, other.id);
	}

}
