package exercicios05082026parte0.oo.exemplo1;

public class MainCalculadora {

	public static void main(String[] args) {

		Calculadora calc = new Calculadora();

		System.out.println(calc.somar(10, 20));
		System.out.println(calc.somar(10, 20, 30));

		System.out.println(calc.somar(10l, 20l));
		System.out.println(calc.somar(10l, 20l, 30l));
		
		System.out.println(calc.somar(1.5f, 2.5f));
		System.out.println(calc.somar(1.5f, 2.5f, 3.5f));

		System.out.println(calc.somar(2.5, 3.7));
		System.out.println(calc.somar(2.5, 3.7, 4.8));

		int[] vetor = { 10, 20, 30, 40, 50 };
		System.out.println(calc.somar(vetor));
	}
}