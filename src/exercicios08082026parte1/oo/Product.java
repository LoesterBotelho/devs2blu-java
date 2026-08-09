package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public abstract class Product {

	private final Long id;
	private final String name;
	private BigDecimal price;

	protected Product(Long id, String name, BigDecimal price) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}

		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Invalid name");
		}

		if (price == null || price.signum() < 0) {
			throw new IllegalArgumentException("Invalid price");
		}

		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void changePrice(BigDecimal price) {
		if (price == null || price.signum() < 0) {
			throw new IllegalArgumentException("Invalid price");
		}

		this.price = price;
	}

	public abstract String getDescription();

	public abstract String getCategory();

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}