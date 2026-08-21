package exercicios20082026parte0.oo.exercicio002.outros;

public class MainVeiculo {

	public static void main(String[] args) {

		Veiculo carro = new Carro();

		carro.mover();
		carro.parar();
		carro.buzinar();

		Veiculo.exibirInformacoesGerais();

		System.out.println(Veiculo.FABRICANTE);
		System.out.println(Veiculo.VELOCIDADE_MAXIMA);
		System.out.println(Veiculo.IMPOSTO);
	}
}