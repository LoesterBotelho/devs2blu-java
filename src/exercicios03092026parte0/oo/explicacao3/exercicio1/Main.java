package exercicios03092026parte0.oo.explicacao3.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	// ==========================================
	// 1. UNKNOWN WILDCARD (?)
	// ==========================================
	// Aceita uma lista de qualquer tipo. É útil para operações de leitura genérica
	// (geralmente tratado como Object).
	public static void imprimirQualquerLista(List<?> lista) {
		
		System.out.println("--- Imprimindo com Unknown Wildcard (?) ---");
		
		for (Object obj : lista) {
			System.out.println(obj);
		}
		
	}

	// ==========================================
	// 2. EXTENDS WILDCARD (? extends T) - Upper Bound
	// ==========================================
	// Aceita o tipo Fruta ou qualquer subtipo dela (ex: Uva, UvaVermelha).
	// Ideal para LEITURA (você tem certeza de que os elementos retornados são pelo
	// menos Frutas).
	public static void processarFrutas(List<? extends Fruta> listaDeFrutas) {
		
		System.out.println("--- Imprimindo com Extends Wildcard (? extends Fruta) ---");
		
		for (Fruta fruta : listaDeFrutas) {
			System.out.println("Fruta detectada: " + fruta.getNome());
		}
		
	}

	// ==========================================
	// 3. SUPER WILDCARD (? super T) - Lower Bound
	// ==========================================
	// Aceita a Uva ou qualquer supertipo dela (Fruta ou Object).
	// Ideal para ESCRITA (permite adicionar Uvas ou subclasses de Uva na lista de
	// forma segura).
	public static void adicionarUvas(List<? super Uva> lista) {
		
		System.out.println("--- Adicionando com Super Wildcard (? super Uva) ---");
		
		lista.add(new Uva());
		lista.add(new UvaVermelha()); // UvaVermelha é subtipo de Uva, logo também é aceita
		
		System.out.println("Itens adicionados com sucesso!");
	}


	public static void main(String[] args) {
		
		// Testando Unknown Wildcard (?)
		List<String> listaDeStrings = new ArrayList<>();
		listaDeStrings.add("Texto A");
		listaDeStrings.add("Texto B");
		
		imprimirQualquerLista(listaDeStrings);

		System.out.println();

		//------------------------------------------------------------------------------------
		
		// Testando Extends Wildcard (? extends Fruta)
		List<Uva> listaDeUvas = new ArrayList<>();
		listaDeUvas.add(new Uva());
		listaDeUvas.add(new Uva());
		processarFrutas(listaDeUvas); // Funciona porque Uva estende Fruta

		System.out.println();

		//------------------------------------------------------------------------------------
		
		// Testando Super Wildcard (? super Uva)
		List<Fruta> listaDeFrutasGenerica = new ArrayList<>();
		adicionarUvas(listaDeFrutasGenerica); // Funciona porque Fruta é supertipo de Uva

		// Verificando os itens que foram adicionados via super wildcard
		System.out.println("Itens presentes na lista de frutas após o método super:");
		for (Object f : listaDeFrutasGenerica) {
			System.out.println(((Fruta) f).getNome());
		}
		
		//------------------------------------------------------------------------------------
		
	}
}