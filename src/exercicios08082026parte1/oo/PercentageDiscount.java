package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class PercentageDiscount implements DiscountPolicy {

	private final BigDecimal percentage;

	public PercentageDiscount(BigDecimal percentage) {

		if (percentage == null || percentage.signum() < 0 || percentage.compareTo(BigDecimal.valueOf(100)) > 0) {

			throw new IllegalArgumentException("Invalid percentage");
		}

		this.percentage = percentage;
	}

	@Override
	public BigDecimal calculate(BigDecimal originalPrice) {

		BigDecimal discount = originalPrice.multiply(percentage).divide(BigDecimal.valueOf(100));

		return originalPrice.subtract(discount);
	}

	@Override
	public String toString() {
		return "PercentageDiscount [percentage=" + percentage + "]";
	}

}