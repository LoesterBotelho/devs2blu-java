package exercicios20082026parte0.oo.exercicio2;

public class Gato extends Mamifero implements AnimalDomestico, AnimalEstimacao {
	private String raca;

	public Gato(String nome, String raca) {
		super(nome);
		this.raca = raca;
	}

	@Override
	public String emitirSom() {
		return "Miau";
	}

	@Override
	public String amamentar() {
		return "Gata amamentando";
	}

	@Override
	public void alimentar() {
		System.out.println("Alimentando o gato");
	}

	@Override
	public void levarVeterinario() {
		System.out.println("Levando gato ao veterinário");
	}

	@Override
	public void chamarVeterinario() {
		System.out.println("Chamando veterinário para o gato");
	}

	@Override
	public void brincar() {
		System.out.println("Gato brincando");
	}

	@Override
	public void levarPassear() {
		System.out.println("Levando gato para passear");
	}

	@Override
	public String toString() {
		return "Gato [raca=" + raca + "]";
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

}
