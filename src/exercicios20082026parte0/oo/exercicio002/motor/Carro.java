package exercicios20082026parte0.oo.exercicio002.motor;

public class Carro implements VeiculoCompleto {

	@Override
	public void mover() {
		System.out.println("Carro se movendo");
	}

	@Override
	public void ligar() {
		System.out.println("Motor ligado");
	}

	@Override
	public void desligar() {
		System.out.println("Motor desligado");
	}

}