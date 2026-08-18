package exercicios17082026parte0.oo.exercicio1;

public class RegularCustomer extends Customer {
    public RegularCustomer(String customerId, String name, String email) {
        super(customerId, name, email);
    }

    @Override
    public void printCustomerType() {
        System.out.println("Customer Type: Regular | Name: " + getName());
    }
}