package exercicios08082026parte1.oo;

public final class Pending implements OrderStatus {

	@Override
	public String description() {
		return "Pending";
	}

	@Override
	public String toString() {
		return "Pending []";
	}

}