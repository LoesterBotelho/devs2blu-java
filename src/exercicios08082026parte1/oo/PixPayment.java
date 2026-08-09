package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class PixPayment implements PaymentMethod {

	@Override
	public void pay(BigDecimal amount) {

		System.out.println("Paid $" + amount + " using PIX");
	}

	@Override
	public String getName() {
		return "PIX";
	}

	@Override
	public String toString() {
		return "PixPayment []";
	}

}