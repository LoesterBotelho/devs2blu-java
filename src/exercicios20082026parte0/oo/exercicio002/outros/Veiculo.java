package exercicios20082026parte0.oo.exercicio002.outros;

public interface Veiculo {

	// Constantes (public static final automaticamente)
	String FABRICANTE = "FIAT";
	int VELOCIDADE_MAXIMA = 200;
	double IMPOSTO = 0.15;

	// Método abstrato (public abstract automaticamente)
	void mover();

	// Método default
	default void parar() {
		System.out.println("Veículo parando...");
		registrarLog();
	}

	// Outro método default
	default void buzinar() {
		System.out.println("Bi Bi!");
	}

	// Método static
	static void exibirInformacoesGerais() {
		System.out.println("Interface Veiculo");
		logSistema();
	}

	// Método private (Java 9+)
	private void registrarLog() {
		System.out.println("Log da operação");
	}

	// Método private static (Java 9+)
	private static void logSistema() {
		System.out.println("Log estático do sistema");
	}
}