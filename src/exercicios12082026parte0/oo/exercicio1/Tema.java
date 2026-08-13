package exercicios12082026parte0.oo.exercicio1;

import java.util.Arrays;
import java.util.Objects;

public class Tema {

	int id;
	String nome;
	double valorAluguel;
	String corToalha;
	String[] itensTema;

	public Tema() {
	}

	public Tema(String Nome, double ValorAluguel, String CorToalha) {
		nome = Nome;
		valorAluguel = ValorAluguel;
		corToalha = CorToalha;
	}

	public Tema(String nome, double valorAluguel, String corToalha, String[] itensTema) {
		super();
		this.nome = nome;
		this.valorAluguel = valorAluguel;
		this.corToalha = corToalha;
		this.itensTema = itensTema;
	}

	void exibirTema() {
		System.out.println("Nome tema: " + nome);
		System.out.println("Valor tema: " + valorAluguel);
		System.out.println("Cor toalha: " + corToalha);

		for (String string : itensTema) {
			System.out.println("Itens do tema: " + string);
		}
		System.out.println("Tema cadastrado com sucesso");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public String getCorToalha() {
		return corToalha;
	}

	public void setCorToalha(String corToalha) {
		this.corToalha = corToalha;
	}

	public String[] getItensTema() {
		return itensTema;
	}

	public void setItensTema(String[] itensTema) {
		this.itensTema = itensTema;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", nome=" + nome + ", valorAluguel=" + valorAluguel + ", corToalha=" + corToalha
				+ ", itensTema=" + Arrays.toString(itensTema) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		return id == other.id;
	}

}
