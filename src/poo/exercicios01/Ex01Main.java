package poo.exercicios01;

public class Ex01Main {

	public static void main(String[] args) {
		Eletronico tv = new Eletronico(1, "Televisão 42 pol", "Preta");
		tv.ligar();
		tv.desligar();
		tv.exibir();

		Eletronico geladeira = new Eletronico();
		geladeira.setNumero(2);
		geladeira.setCor("Cinza");
		geladeira.setNome("Geladeira 1000L 220v");

		geladeira.ligar();
		geladeira.desligar();
		geladeira.exibir();

	}
}
