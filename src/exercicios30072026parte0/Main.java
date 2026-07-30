package exercicios30072026parte0;

public class Main {
	public static void main(String[] args) {

		Calculadora calc = new Calculadora();

		int resultado1 = calc.soma(1, 1);
		float resultado2 = calc.soma(1.0f, 1.0f);
		double resultado3 = calc.soma(1.0, 1.0);
		long resultado4 = calc.soma(1l, 1l);

		System.out.println("resultado1 : " + resultado1);
		System.out.println("resultado2 : " + resultado2);
		System.out.println("resultado3 : " + resultado3);
		System.out.println("resultado4 : " + resultado4);

		int[] entradaInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		float[] entradaFloat = { 1.1f, 2.2f, 3.3f, 4.4f, 5.5f, 6.6f, 7.7f, 8.8f, 9.9f, 10.10f };
		double[] entradaDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.10 };
		long[] entradaLong = { 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l };

		int resultado5 = calc.soma(entradaInt);
		float resultado6 = calc.soma(entradaFloat);
		double resultado7 = calc.soma(entradaDouble);
		long resultado8 = calc.soma(entradaLong);

		System.out.println();
		System.out.println("resultado5 : " + resultado5);
		System.out.println("resultado6 : " + resultado6);
		System.out.println("resultado7 : " + resultado7);
		System.out.println("resultado8 : " + resultado8);
		System.out.println();

		for (var i = 0; i < entradaInt.length; i++) {
			System.out.println(entradaInt[i]);
		}

		System.out.println();
		
		entradaInt[0] = 1;
		entradaInt[1] = 2;
		entradaInt[2] = 3;
		entradaInt[3] = 4;
		entradaInt[4] = 5;
		entradaInt[5] = 6;
		entradaInt[6] = 7;
		entradaInt[7] = 8;
		entradaInt[8] = 9;
		entradaInt[9] = 10;

		System.out.println(entradaInt[0]);
		System.out.println(entradaInt[1]);
		System.out.println(entradaInt[2]);
		System.out.println(entradaInt[3]);
		System.out.println(entradaInt[4]);
		System.out.println(entradaInt[5]);
		System.out.println(entradaInt[6]);
		System.out.println(entradaInt[7]);
		System.out.println(entradaInt[8]);
		System.out.println(entradaInt[9]);

	}
}
