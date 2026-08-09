package exercicios09082026parte1.oo;

public interface Payable {

    double calculateSalary();

    default void printPayment() {
        System.out.println("Payment: " + calculateSalary());
    }
}