package exercicios08092026parte0.oo.exercicio2;

import java.util.ArrayList;

public class MainTestes {
	public static void main(String[] args) {
		
		Eletronico eletronico1 = new Eletronico(1L, "Smartphone", 2500.0, 12);
		Roupa roupa1 = new Roupa(2L, "Camiseta", 89.90, "M");

		Estoque<Produto> estoqueGeral = new Estoque<>(1L, new ArrayList<>());

		estoqueGeral.adicionarItem(eletronico1);
		estoqueGeral.adicionarItem(roupa1);

		estoqueGeral.listarItens();
	}
}