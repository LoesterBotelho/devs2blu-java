package exercicios10082026parte1.oo;

import java.math.BigDecimal;

public interface Payable {

	BigDecimal calculateAmount();

	default boolean isFree() {
		return calculateAmount().compareTo(BigDecimal.ZERO) == 0;
	}

}