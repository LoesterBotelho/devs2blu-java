package exercicios12082026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private List<Livro> acervo;

	public Biblioteca() {
		this.acervo = new ArrayList<>();
	}

	public void adicionarLivro(Livro livro) {
		this.acervo.add(livro);
	}

	public List<Livro> getAcervo() {
		return acervo;
	}

	@Override
	public String toString() {
		return "Biblioteca [acervo=" + acervo + "]";
	}
}