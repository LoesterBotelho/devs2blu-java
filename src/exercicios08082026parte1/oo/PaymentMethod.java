package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public interface PaymentMethod {

	void pay(BigDecimal amount);

	String getName();

}