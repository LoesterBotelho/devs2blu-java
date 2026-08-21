package exercicios20082026parte0.oo.exercicio2;

public class Cachorro extends Mamifero implements AnimalDomestico, AnimalEstimacao {
    private String tamanho;
    private String raca;

    public Cachorro(String nome, String tamanho, String raca) {
        super(nome);
        this.tamanho = tamanho;
        this.raca = raca;
    }

    @Override
    public String emitirSom() {
        return "Au au";
    }

    @Override
    public String amamentar() {
        return "Cachorra amamentando";
    }

    @Override
    public void alimentar() {
        System.out.println("Alimentando o cachorro");
    }

    @Override
    public void levarVeterinario() {
        System.out.println("Levando cachorro ao veterinário");
    }

    @Override
    public void chamarVeterinario() {
        System.out.println("Chamando veterinário para o cachorro");
    }

    @Override
    public void brincar() {
        System.out.println("Cachorro brincando");
    }

    @Override
    public void levarPassear() {
        System.out.println("Levando cachorro para passear");
    }

	@Override
	public String toString() {
		return "Cachorro [tamanho=" + tamanho + ", raca=" + raca + "]";
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
    
    
}