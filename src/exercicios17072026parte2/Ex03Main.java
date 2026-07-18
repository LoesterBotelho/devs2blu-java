package exercicios17072026parte2;

public class Ex03Main {
	
	public static void main(String[] args) {
		
		getAuthor();
		

		Ex03 ex03 = new Ex03(1000, 32.87, 33.92);
				
		
        System.out.printf("Valor pago pelas ações.....: R$ %.2f%n", ex03.getValorCompra());
        System.out.printf("Corretagem na compra.......: R$   %.2f%n", ex03.getValorCorretagemCompra());
        System.out.printf("Valor da venda das ações...: R$ %.2f%n", ex03.getValorVenda());
        System.out.printf("Corretagem na venda........: R$   %.2f%n", ex03.getValorCorretagemVenda());
        System.out.printf("Lucro líquido..............: R$  %.2f%n", ex03.getLucroPrejuizo());
        
        		
		System.out.println("\n" + ex03.toString());
		
	
	}
		
	public static void getAuthor() {
		System.out.println("---------------------------------------------------");
		System.out.println("Author : Loester Botelho");	
		System.out.println("---------------------------------------------------\n");
	}
	
}
