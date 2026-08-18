package exercicios17082026parte0.oo.exercicio1;

public class VipCustomer extends Customer {
    private double discountRate; 

    public VipCustomer(String customerId, String name, String email, double discountRate) {
        super(customerId, name, email);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void printCustomerType() {
        System.out.println("Customer Type: VIP (Discount: " + (discountRate * 100) + "%) | Name: " + getName());
    }
}