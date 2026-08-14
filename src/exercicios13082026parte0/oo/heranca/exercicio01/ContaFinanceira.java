package exercicios13082026parte0.oo.heranca.exercicio01;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ContaFinanceira {

	Long getId();

	String getDescricao();

	BigDecimal getValor();

	LocalDate getDataEmissao();

	LocalDate getDataVencimento();

	LocalDate getDataPagamento();

	boolean isPaga();

	String getObservacao();

	void pagar(LocalDate dataPagamento);

	void cancelar();
}