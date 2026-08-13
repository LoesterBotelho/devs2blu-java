package exercicios12082026parte0.oo.exercicio3;

public class Bateria {
	private int capacidadeMaxima;
	private int capacidadeMah;
	private String marca;

	public Bateria(int capacidadeMaxima, String marca) {
		this.capacidadeMaxima = capacidadeMaxima;
		this.capacidadeMah = capacidadeMaxima;
		this.marca = marca;
	}

	public void consumirCarga(int valor) {
		this.capacidadeMah -= valor;
		if (this.capacidadeMah < 0) {
			this.capacidadeMah = 0;
		}
	}

	public void recarregar(int horas) {
		int cargaRecuperada = horas * 2500;
		this.capacidadeMah += cargaRecuperada;

		if (this.capacidadeMah > this.capacidadeMaxima) {
			this.capacidadeMah = this.capacidadeMaxima;
		}

		System.out.println( "Recarregando por " + horas + "h com carregador rápido. Carga adicionada: " + cargaRecuperada + "mAh");
	}

	public int getCapacidadeMah() {
		return capacidadeMah;
	}

	public boolean estaCarregada() {
		return capacidadeMah > 0;
	}

	@Override
	public String toString() {
		return "Bateria [" + marca + ", Carga: " + capacidadeMah + "/" + capacidadeMaxima + "mAh]";
	}
}