package exercicios17082026parte0.oo.exercicio1;

public class PhysicalProduct extends Product {
    private double weightInKg;
    private double shippingCost;

    public PhysicalProduct(String productId, String name, double price, ProductCategory category, double weightInKg, double shippingCost) {
        super(productId, name, price, category);
        this.weightInKg = weightInKg;
        this.shippingCost = shippingCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 1; //100%
    }

    @Override
    public void displayProductDetails() {
        System.out.println("[Physical Product] " + getName() + " | Price: $" + getPrice() + " | Weight: " + weightInKg + "kg | Shipping: $" + shippingCost);
    }
}