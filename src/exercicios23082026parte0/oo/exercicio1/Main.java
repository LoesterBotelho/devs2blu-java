package exercicios23082026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		ContaPagar contaPagar = new ContaPagar(
				new BigDecimal("1000.00"),
				LocalDate.of(2026, 8, 30),
				null,
				new BigDecimal("50.00"),
				new BigDecimal("20.00"),
				BigDecimal.ZERO,
				"Conta de fornecedor");

		ContaReceber contaReceber = new ContaReceber(
				new BigDecimal("2000.00"),
				LocalDate.of(2026, 8, 25),
				null,
				new BigDecimal("100.00"),
				new BigDecimal("50.00"),
				BigDecimal.ZERO,
				"Venda para cliente");

		System.out.println("   CONTA A PAGAR");

		System.out.println("Valor: " + contaPagar.getValor());
		System.out.println("Vencimento: " + contaPagar.getDataVencimento());
		System.out.println("Juros: " + contaPagar.getJuros());
		System.out.println("Multa: " + contaPagar.getMulta());
		System.out.println("Valor pago: " + contaPagar.getValorPago());
		System.out.println("Observação: " + contaPagar.getObservacao());
		System.out.println("Valor total: " + contaPagar.calcularValorTotal());
		System.out.println("Está pago: " + contaPagar.estaPago());
		System.out.println("Saldo: " + contaPagar.calcularSaldo());

		System.out.println();
		System.out.println("   CONTA A RECEBER");

		System.out.println("Valor: " + contaReceber.getValor());
		System.out.println("Vencimento: " + contaReceber.getDataVencimento());
		System.out.println("Juros: " + contaReceber.getJuros());
		System.out.println("Multa: " + contaReceber.getMulta());
		System.out.println("Valor pago: " + contaReceber.getValorPago());
		System.out.println("Observação: " + contaReceber.getObservacao());
		System.out.println("Valor total: " + contaReceber.calcularValorTotal());
		System.out.println("Está pago: " + contaReceber.estaPago());
		System.out.println("Saldo: " + contaReceber.calcularSaldo());

		

		Financeiro financeiroPagar = contaPagar;
		Financeiro financeiroReceber = contaReceber;

		System.out.println();
		
		System.out.println(
				"Conta a pagar - total: "
						+ financeiroPagar.calcularValorTotal());

		System.out.println(
				"Conta a receber - total: "
						+ financeiroReceber.calcularValorTotal());

	}

}
