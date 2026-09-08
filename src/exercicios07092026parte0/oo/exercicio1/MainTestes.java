package exercicios07092026parte0.oo.exercicio1;

import java.util.ArrayList;

public class MainTestes {
	public static void main(String[] args) {
		Livro livro1 = new Livro(1L, "Java para Iniciantes", "João Silva");
		Livro livro2 = new Livro(2L, "Orientacao a Objetos", "Maria Souza");

		RegistroGenerico<Livro> reg1 = new RegistroGenerico<>(100L, livro1);
		RegistroGenerico<Livro> reg2 = new RegistroGenerico<>(101L, livro2);

		ProcessadorDeRegistros processador = new ProcessadorDeRegistros(1L, new ArrayList<>());
		processador.adicionar(reg1);
		processador.adicionar(reg2);

		processador.exibirRegistros();
	}
}