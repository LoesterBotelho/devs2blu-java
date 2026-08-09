package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class OrderService {

	private final DiscountPolicy discountPolicy;
	private final PaymentMethod paymentMethod;

	public OrderService(DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {
		this.discountPolicy = discountPolicy;
		this.paymentMethod = paymentMethod;
	}

	public void checkout(Order order) {

		BigDecimal original = order.total();

		BigDecimal finalPrice = discountPolicy.calculate(original);

		System.out.println("Original: $" + original);

		System.out.println("Final: $" + finalPrice);

		paymentMethod.pay(finalPrice);

		order.markAsPaid();
	}

	@Override
	public String toString() {
		return "OrderService [discountPolicy=" + discountPolicy + ", paymentMethod=" + paymentMethod + "]";
	}

}