package test;

public class Repeticao {
	
	public static void main(String[] args) {

		int contador = 1;

		
		System.out.println("WHILE -----------\n");
		contador = 1;
		while (contador <= 5) {
		System.out.println("Número: " + contador);
		contador++;
		}
		
		
		System.out.println("\nDO WHILE -----------\n");
		contador = 1;
		do {
		System.out.println("Número: " + contador);
		contador++;
		} while (contador <= 5);

		
		System.out.println("\nFOR -----------\n");		
		for (int i = 1; i <= 5; i++) {			
			System.out.println("Número: " + i);			
		}		
	
		
		System.out.println("\nFOREACH -----------\n");			
		Item[] items = {
				new Item("Notebook"),				
				new Item("Mouse"),				
				new Item("Teclado")				
				};

		
				for (Item item : items) {				
				System.out.println(item.getNome());			
				}
				
				
	
	}
}
