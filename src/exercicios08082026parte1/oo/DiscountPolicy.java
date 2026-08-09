package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public interface DiscountPolicy {

	BigDecimal calculate(BigDecimal originalPrice);
}