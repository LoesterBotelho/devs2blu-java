package exercicios08082026parte1.oo;

public sealed interface OrderStatus permits Pending, Paid, Cancelled {

	String description();
}