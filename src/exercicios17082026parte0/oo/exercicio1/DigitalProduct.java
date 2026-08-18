package exercicios17082026parte0.oo.exercicio1;

public class DigitalProduct extends Product {
    private double fileSizeInMB;
    private String downloadLink;

    public DigitalProduct(String productId, String name, double price, ProductCategory category, double fileSizeInMB, String downloadLink) {
        super(productId, name, price, category);
        this.fileSizeInMB = fileSizeInMB;
        this.downloadLink = downloadLink;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.30;
    }

    @Override
    public void displayProductDetails() {
        System.out.println("[Digital Product] " + getName() + " | Price: $" + getPrice() + " | Size: " + fileSizeInMB + "MB | Link: " + downloadLink);
    }
}