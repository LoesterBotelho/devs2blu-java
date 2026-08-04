package exercicios30072026parte1.oo.exercicio3;

import exercicios30072026parte1.oo.classes.Console;
import exercicios30072026parte1.oo.exercicio3.classes.ContaCorrente;

public class MainExercicio3 {
	public static void main(String[] args) {
		Console console = new Console();

		console.imprimir("CONTA CORRENTE");
		int numero = console.lerInteiro("Digite o número da conta:");

		int opcaoEspecial = console.lerInteiro("A conta é especial? (1- Sim / 2- Não):");
		boolean especial = (opcaoEspecial == 1);

		int limiteInt = console.lerInteiro("Digite o valor do limite da conta:");
		double limite = (double) limiteInt;

		int saldoInicialInt = console.lerInteiro("Digite o saldo inicial da conta:");
		double saldoInicial = (double) saldoInicialInt;

		ContaCorrente conta = new ContaCorrente(numero, saldoInicial, especial, limite);

		boolean continuar = true;
		while (continuar) {
			console.imprimir("\nMENU CONTA CORRENTE");
			console.imprimir("1. Consultar Saldo");
			console.imprimir("2. Depositar");
			console.imprimir("3. Sacar");
			console.imprimir("4. Verificar Cheque Especial");
			console.imprimir("5. Sair");

			int opcao = console.lerInteiro("Escolha uma opção:");

			switch (opcao) {
			case 1:
				console.imprimir("Saldo atual: R$ " + conta.consultarSaldo());
				break;
			case 2:
				int depositoInt = console.lerInteiro("Digite o valor a depositar:");
				conta.depositar((double) depositoInt);
				console.imprimir("Depósito realizado com sucesso! Saldo atual: R$ " + conta.consultarSaldo());
				break;
			case 3:
				int saqueInt = console.lerInteiro("Digite o valor a sacar:");
				boolean sucesso = conta.sacar((double) saqueInt);
				if (sucesso) {
					console.imprimir("Saque realizado com sucesso! Saldo atual: R$ " + conta.consultarSaldo());
				} else {
					console.imprimir("Saque não permitido! Saldo e limite insuficientes.");
				}
				break;
			case 4:
				if (conta.estaUsandoChequeEspecial()) {
					console.imprimir("Atenção: A conta ESTÁ usando cheque especial (Saldo Negativo).");
				} else {
					console.imprimir("A conta NÃO está usando cheque especial.");
				}
				break;
			case 5:
				continuar = false;
				console.imprimir("Encerrando o programa...");
				break;
			default:
				console.imprimir("Opção inválida!");
				break;
			}
		}

		console.fechar();
	}
}