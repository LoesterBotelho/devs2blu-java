package exercicios30082026parte0.oo.exercicio1;

public class TesteException {

	// ------------------------------------------------------------------------------------------------
	
	static void metodo2() {
		System.out.println("inicio do metodo2");
		int[] array = new int[10];

		try {
			for (int i = 0; i <= 15; i++) {
				array[i] = i;
				System.out.println(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro capturado: Índice do array fora dos limites permitidos.");
		}

		System.out.println("fim do metodo2");
	}

	// ------------------------------------------------------------------------------------------------
	
	static void metodo1() {
		System.out.println("inicio do metodo1");
		metodo2();
		System.out.println("fim do metodo1");
	}

	// ------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		System.out.println("inicio do main");
		metodo1();
		System.out.println("fim do main");
	}
	
	// ------------------------------------------------------------------------------------------------	

}
