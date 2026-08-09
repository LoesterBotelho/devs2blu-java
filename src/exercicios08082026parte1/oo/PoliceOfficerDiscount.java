package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class PoliceOfficerDiscount implements DiscountPolicy {

	private static final BigDecimal DISCOUNT = BigDecimal.valueOf(20);

	@Override
	public BigDecimal calculate(BigDecimal originalPrice) {

		BigDecimal discount = originalPrice.multiply(DISCOUNT).divide(BigDecimal.valueOf(100));

		return originalPrice.subtract(discount);
	}

	@Override
	public String toString() {
		return "PoliceOfficerDiscount []";
	}

}