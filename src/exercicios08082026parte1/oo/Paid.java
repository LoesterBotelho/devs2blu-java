package exercicios08082026parte1.oo;

public final class Paid implements OrderStatus {

	@Override
	public String description() {
		return "Paid";
	}

	@Override
	public String toString() {
		return "Paid []";
	}

}