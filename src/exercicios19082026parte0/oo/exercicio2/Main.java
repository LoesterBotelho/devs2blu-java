package exercicios19082026parte0.oo.exercicio2;

public class Main {

	public static void main(String[] args) {
		
		carregarAutor();
		
		PF heloisa = new PF("Heloisa", "788.668.290-48" , 4000.00);
		heloisa.calcularIIRF();
		
		
		PJ loesterEmpresa = new PJ("Next-Gen Technology Software & Hardware","90.169.024/0001-61",120000.0);
		loesterEmpresa.calcularIIRF();
		
		
		heloisa.Exibir();
		loesterEmpresa.Exibir();
		
	}
	
	public static void carregarAutor() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Author : Loester Botelho");
		System.out.println("--------------------------------------------------------------------------------");
	}
}