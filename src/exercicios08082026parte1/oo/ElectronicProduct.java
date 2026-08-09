package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public final class ElectronicProduct extends Product {

	private final int warrantyMonths;

	public ElectronicProduct(Long id, String name, BigDecimal price, int warrantyMonths) {
		super(id, name, price);

		if (warrantyMonths < 0) {
			throw new IllegalArgumentException("Invalid warranty");
		}

		this.warrantyMonths = warrantyMonths;
	}

	public int getWarrantyMonths() {
		return warrantyMonths;
	}

	@Override
	public String getDescription() {
		return getName() + " - " + warrantyMonths + " months warranty";
	}

	@Override
	public String getCategory() {
		return "ELECTRONICS";
	}

	@Override
	public String toString() {
		return "ElectronicProduct [warrantyMonths=" + warrantyMonths + "]";
	}

}