package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public record OrderItem(Product product, int quantity) {

	public OrderItem {

		if (product == null) {
			throw new IllegalArgumentException("Product cannot be null");
		}

		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be positive");
		}
	}

	public BigDecimal total() {

		return product.getPrice().multiply(BigDecimal.valueOf(quantity));
	}

	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", quantity=" + quantity + "]";
	}

}