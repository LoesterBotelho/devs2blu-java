package exercicios12082026parte0.oo.exercicio3;

public class Celular {
	private String modelo;
	private Bateria bateria;

	public Celular(String modelo) {
		this.modelo = modelo;		// 
		this.bateria = new Bateria(5000, "Íon de Lítio Original Samsung");
	}

	public void ligar() {
		if (bateria.estaCarregada()) {
			System.out.println("O celular " + modelo + " ligou!");
			System.out.println("Nível da bateria no momento: " + bateria.getCapacidadeMah() + "mAh");
		} else {
			System.out.println("O celular não liga. Bateria descarregada.");
		}
	}

	public void usarSmartphone(String nomeApp) {
		if (bateria.estaCarregada()) {
			System.out.println("Usando o app: " + nomeApp + " por 1 hora (com apps em segundo plano)...");

			int consumoGasto = 400;
			if (nomeApp.equals("YouTube") || nomeApp.equals("Tiktok")) {
				consumoGasto = 550;
			}

			bateria.consumirCarga(consumoGasto);
			System.out.println("Nível da bateria após uso: " + bateria.getCapacidadeMah() + "mAh");
		} else {
			System.out.println("O celular está descarregado! Não foi possível usar o " + nomeApp);
		}
	}

	public void carregarBateria(int horas) {
		System.out.println("Colocando o celular " + modelo + " para carregar...");
		bateria.recarregar(horas);
		System.out.println("Nível da bateria após recarga: " + bateria.getCapacidadeMah() + "mAh");
	}

	@Override
	public String toString() {
		return "Celular [modelo=" + modelo + ", " + bateria + "]";
	}
}