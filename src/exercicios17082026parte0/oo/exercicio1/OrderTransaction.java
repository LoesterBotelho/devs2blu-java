package exercicios17082026parte0.oo.exercicio1;

public class OrderTransaction {
    private final String orderId;
    private Customer customer;
    private Product product;
    private OrderStatus status;

    public OrderTransaction(String orderId, Customer customer, Product product) {
        this.orderId = orderId;
        this.customer = customer;
        this.product = product;
        this.status = OrderStatus.PENDING;
    }

    public void processOrder() {
        double finalPrice = product.getPrice();
        double tax = product.calculateTax();
 
        if (customer instanceof VipCustomer vip) {
            double discount = finalPrice * vip.getDiscountRate();
            finalPrice -= discount;
            System.out.println("-> VIP Discount applied: -$" + discount);
        }

        finalPrice += tax;
        this.status = OrderStatus.PAID;

        System.out.println("--- Order " + orderId + " Successfully Processed ---");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Product: " + product.getName());
        System.out.println("Tax: $" + tax);
        System.out.println("Total Final Amount: $" + finalPrice);
        System.out.println("Status: " + status);
        System.out.println("----------------------------------------------");
    }
}