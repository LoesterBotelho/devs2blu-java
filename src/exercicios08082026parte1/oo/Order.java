package exercicios08082026parte1.oo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Order {

	private final Long id;
	private final Customer customer;

	private final List<OrderItem> items = new ArrayList<>();

	private OrderStatus status = new Pending();

	public Order(Long id, Customer customer) {

		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid order id");
		}

		if (customer == null) {
			throw new IllegalArgumentException("Customer is required");
		}

		this.id = id;
		this.customer = customer;
	}

	public void addItem(OrderItem item) {

		if (status instanceof Paid) {
			throw new IllegalStateException("Cannot modify paid order");
		}

		items.add(item);
	}

	public BigDecimal total() {

		return items.stream().map(OrderItem::total).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void markAsPaid() {
		this.status = new Paid();
	}

	public void cancel() {
		this.status = new Cancelled();
	}

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<OrderItem> getItems() {
		return List.copyOf(items);
	}

	public OrderStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", items=" + items + ", status=" + status + "]";
	}

}