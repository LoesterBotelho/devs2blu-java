package exercicios24072026.explicacao;

public class ForAninhado {
	public static void main(String[] args) {

		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2; j++) {
				for (int k = 1; k <= 2; k++) {
					System.out.println("i=" + i + " j=" + j + " k=" + k);
				}
			}
		}

	}
}
