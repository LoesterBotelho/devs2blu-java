package exercicios08092026parte0.oo.exercicio3;

import java.util.ArrayList;

public class MainTestes {
	public static void main(String[] args) {
		
		Cachorro cachorro1 = new Cachorro(1L, "Rex", "Labrador");
		Gato gato1 = new Gato(2L, "Mimi", "Branco");

		Abrigo<Animal> abrigoGeral = new Abrigo<>(1L, new ArrayList<>());
		
		abrigoGeral.adicionarAnimal(cachorro1);
		abrigoGeral.adicionarAnimal(gato1);

		abrigoGeral.listarAnimais();
	}
}