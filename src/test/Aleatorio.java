package test;

import java.util.Random;

public class Aleatorio {

	public static void main(String[] args) {
		Random rand = new Random(20L);
		System.out.println("Número Aleatório 1: " + rand.nextInt(100));
		System.out.println("Número Aleatório 2: " + rand.nextInt(100));
		System.out.println("Número Aleatório 3: " + rand.nextInt(100));
		System.out.println("Alterando o seed para alterar a sequência");
		rand.setSeed(5L);
		System.out.println("Número Aleatório 4: " + rand.nextInt(100));
		System.out.println("Número Aleatório 5: " + rand.nextInt(100));
		System.out.println("Número Aleatório 6: " + rand.nextInt(100));
		System.out.println("Definir o seed 20 produz a sequência anterior");
		rand.setSeed(20L);
		System.out.println("Número Aleatório 7: " + rand.nextInt(100));
		System.out.println("Número Aleatório 8: " + rand.nextInt(100));
		System.out.println("Número Aleatório 9: " + rand.nextInt(100));
		}
	
}
