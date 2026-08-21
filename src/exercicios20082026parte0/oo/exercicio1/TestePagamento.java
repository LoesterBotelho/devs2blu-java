package exercicios20082026parte0.oo.exercicio1;

public class TestePagamento {
	public static void main(String[] args) {
		
		getAuthor();
		
		Pagamento cartaocredito = new CartaoCredito("1234 4567 8911 2345" , "Loester Botelho");
		cartaocredito.processarPagamento(10000);
		
		System.out.println("\n-------------------------------------------\n");
		
		Pagamento paypal = new PayPal("loester.developer@yahoo.com.br");
		paypal.processarPagamento(20000);

		
		System.out.println("\n-------------------------------------------\n");
				
		
		Pagamento pix = new PIX("loester.developer@yahoo.com.br");
		pix.processarPagamento(30000);
		
		
		System.out.println("\n-------------------------------------------\n");
				
		
		Pagamento boleto = new Boleto("00197.89486 33683.374996 11527.029554 9 25450000300000" , "21/08/2026");
		boleto.processarPagamento(3000);	
		
		System.out.println("\n-------------------------------------------\n");		
		
	}
	
	public static void getAuthor() {
		System.out.println("-------------------------------------------");
		System.out.println("Author : Loester Botelho");
		System.out.println("-------------------------------------------\n\n");		
	}
	
}
