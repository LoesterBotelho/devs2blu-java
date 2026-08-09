package exercicios08082026parte1.oo;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {

		Customer customer = new Customer(1L, "Loester", "loester@gmail.com");

		Product book = new Book(1L, "Clean Code", BigDecimal.valueOf(150), "Robert Martin");

		Product laptop = new ElectronicProduct(2L, "Laptop", BigDecimal.valueOf(15000), 24);

		Order order = new Order(100L, customer);

		order.addItem(new OrderItem(book, 2));
		order.addItem(new OrderItem(laptop, 1));

		System.out.println("Customer: " + order.getCustomer().name());
		System.out.println("Order total: $" + order.total());

		DiscountPolicy discount = new NoDiscount();
		PaymentMethod payment = new PixPayment();

		OrderService service = new OrderService(discount, payment);

		service.checkout(order);

		OrderStatus status = order.getStatus();

		if (status instanceof Paid paid) {
			System.out.println("Order status: " + paid.description());
		}

		System.out.println("Finished!");
	}
}