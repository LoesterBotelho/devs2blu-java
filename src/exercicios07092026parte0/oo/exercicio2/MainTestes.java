package exercicios07092026parte0.oo.exercicio2;

import java.util.ArrayList;

public class MainTestes {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1L, "Ana Paula", "ana@email.com");
		Cliente cliente2 = new Cliente(2L, "Carlos Eduardo", "carlos@email.com");

		CaixaGenerica<Cliente> caixa1 = new CaixaGenerica<>(10L, cliente1);
		CaixaGenerica<Cliente> caixa2 = new CaixaGenerica<>(11L, cliente2);

		GerenciadorDeCaixas gerenciador = new GerenciadorDeCaixas(1L, new ArrayList<>());
		gerenciador.adicionarCaixa(caixa1);
		gerenciador.adicionarCaixa(caixa2);

		gerenciador.listarItens();
	}
}