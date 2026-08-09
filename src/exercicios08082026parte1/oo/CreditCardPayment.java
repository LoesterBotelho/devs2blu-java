package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class CreditCardPayment implements PaymentMethod {

	private final String lastFourDigits;

	public CreditCardPayment(String lastFourDigits) {

		if (lastFourDigits == null || lastFourDigits.length() != 4) {

			throw new IllegalArgumentException("Invalid card");
		}

		this.lastFourDigits = lastFourDigits;
	}

	@Override
	public void pay(BigDecimal amount) {

		System.out.println("Paid $" + amount + " using credit card ****" + lastFourDigits);
	}

	@Override
	public String getName() {
		return "Credit Card";
	}

	@Override
	public String toString() {
		return "CreditCardPayment [lastFourDigits=" + lastFourDigits + "]";
	}

}