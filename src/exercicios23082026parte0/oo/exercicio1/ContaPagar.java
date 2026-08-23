package exercicios23082026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaPagar extends ContaFinanceira implements Financeiro {

	public ContaPagar() {
		super();
	}

	public ContaPagar(
			BigDecimal valor,
			LocalDate dataVencimento,
			LocalDate dataPagamento,
			BigDecimal juros,
			BigDecimal multa,
			BigDecimal valorPago,
			String observacao) {
		super(
				valor,
				dataVencimento,
				dataPagamento,
				juros,
				multa,
				valorPago,
				observacao);
	}

	@Override
	public BigDecimal calcularValorTotal() {

		return getValor()
				.add(getJuros())
				.add(getMulta());
	}

	@Override
	public boolean estaPago() {

		return getValorPago() != null
				&& getValorPago().compareTo(BigDecimal.ZERO) > 0;
	}

	@Override
	public BigDecimal calcularSaldo() {

		BigDecimal valorPago = getValorPago() != null
				? getValorPago()
				: BigDecimal.ZERO;

		return calcularValorTotal().subtract(valorPago);
	}

}