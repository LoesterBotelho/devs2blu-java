package exercicios20082026parte0.oo.exercicio002.animal;

public class Main {
	public static void main(String[] args) {
		Animal animal = new CachorroImplement();

		animal.respirar();
		animal.emitirSom();

		((Cachorro) animal).emitirSom();
		((Cachorro) animal).buscarBola();
	}
}
