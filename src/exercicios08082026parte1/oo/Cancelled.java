package exercicios08082026parte1.oo;

public final class Cancelled implements OrderStatus {

	@Override
	public String description() {
		return "Cancelled";
	}

	@Override
	public String toString() {
		return "Cancelled []";
	}

}