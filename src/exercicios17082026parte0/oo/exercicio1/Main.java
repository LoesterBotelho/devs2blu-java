package exercicios17082026parte0.oo.exercicio1;

public class Main {
    public static void main(String[] args) {

        Customer regCustomer = new RegularCustomer("C-01", "Carlos Silva", "carlos@email.com");
        Customer vipCustomer = new VipCustomer("C-02", "Ana Souza", "ana@email.com", 0.15); // 100/15 = 0.15 = 15% de desconto

        regCustomer.printCustomerType();
        vipCustomer.printCustomerType();
        System.out.println();


        Product laptop = new PhysicalProduct("P-100", "Notebook Gamer", 15000.00, ProductCategory.ELECTRONICS, 2.5, 50.0);
        Product ebook = new DigitalProduct("P-200", "E-Book Java 25 Advanced", 380.00, ProductCategory.DIGITAL_MEDIA, 15.4, "https://download.store.com/java25");


        laptop.displayProductDetails();
        ebook.displayProductDetails();
        System.out.println();


        OrderTransaction order1 = new OrderTransaction("ORD-9001", regCustomer, laptop);
        order1.processOrder();

        System.out.println();

        OrderTransaction order2 = new OrderTransaction("ORD-9002", vipCustomer, ebook);
        order2.processOrder();
    }
}