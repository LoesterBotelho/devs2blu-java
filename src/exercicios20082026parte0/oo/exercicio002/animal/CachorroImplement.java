package exercicios20082026parte0.oo.exercicio002.animal;

public class CachorroImplement implements Cachorro{

	@Override
	public void respirar() {
		System.out.println("Respirando...");		
	}

	@Override
	public void emitirSom() {
		System.out.println("Au Au Auuuuu");	
	}

	@Override
	public void amamentar() {
		System.out.println("Amamentar");		
	}

	@Override
	public void latir() {
		System.out.println("Latindo...");
	}

	@Override
	public void buscarBola() {
		System.out.println("Pegando Bolinha...");	
	}

}
