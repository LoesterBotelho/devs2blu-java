
package exercicios12082026parte0.oo.exercicio3;

public class Main {
	public static void main(String[] args) {
		Celular meuCelular = new Celular("Samsung Galaxy S25 Ultra 5G");

		meuCelular.ligar();
		meuCelular.usarSmartphone("Instagram");
		meuCelular.usarSmartphone("YouTube");
		meuCelular.usarSmartphone("Facebook");
		meuCelular.usarSmartphone("Tiktok");
		meuCelular.usarSmartphone("Instagram");

		System.out.println();
		meuCelular.carregarBateria(1);

		System.out.println("\nStatus Final: " + meuCelular.toString());
	}
}