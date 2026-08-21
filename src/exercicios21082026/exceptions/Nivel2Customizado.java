package exercicios21082026.exceptions;

public class Nivel2Customizado {
	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria(500.00);

		try {
			
			System.out.println("Tentando sacar R$ 600.00...");
			
			conta.sacar(600.00);
			
		} catch (SaldoInsuficienteException e) {
			
			System.err.println("Erro de Negócio: " + e.getMessage());
			System.err.println("Saldo atual da conta: R$ " + e.getSaldoAtual());
			
		}
		
	}
}
