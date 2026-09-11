package minhaannotations.exercicio2;

import java.util.Objects;

@Version(number="1.1", description="Modulo De Relatório")
public class Modulo {
	private Integer id;
	private String nomeModulo;
	private String packageCompleto;

	public Modulo() {

	}

	public Modulo(Integer id, String nomeModulo, String packageCompleto) {
		this.id = id;
		this.nomeModulo = nomeModulo;
		this.packageCompleto = packageCompleto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}

	public String getPackageCompleto() {
		return packageCompleto;
	}

	public void setPackageCompleto(String packageCompleto) {
		this.packageCompleto = packageCompleto;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + 
				", nomeModulo=" + nomeModulo + 
				", packageCompleto=" + packageCompleto + 
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
		Modulo other = (Modulo) obj;
		return Objects.equals(id, other.id);
	}

}
