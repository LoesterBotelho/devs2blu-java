package exercicios01092026parte0.oo.exercicio1;

import java.util.List;

class ProcessadorAcademico<T extends Number> {
	private List<T> valores;

	public ProcessadorAcademico(List<T> valores) {
		this.valores = valores;
	}

	public double calcularMedia() {

		if (valores == null || valores.isEmpty())
			return 0.0;

		double soma = 0.0;

		for (T valor : valores) {
			
			// Unboxing implícito/explícito de Wrapper para double
			soma += valor.doubleValue();
			
		}

		return soma / valores.size();

	}
}