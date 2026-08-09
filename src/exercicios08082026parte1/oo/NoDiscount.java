package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class NoDiscount implements DiscountPolicy {

	@Override
	public BigDecimal calculate(BigDecimal originalPrice) {
		return originalPrice;
	}

	@Override
	public String toString() {
		return "NoDiscount []";
	}

}