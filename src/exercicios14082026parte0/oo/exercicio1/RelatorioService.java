package exercicios14082026parte0.oo.exercicio1;

public interface RelatorioService {

	String titulo = "Relatorio Padrao";

	default void gerarCabecalho() {
		System.out.println("--- " + titulo + " ---");
	}

	void exportar();
}