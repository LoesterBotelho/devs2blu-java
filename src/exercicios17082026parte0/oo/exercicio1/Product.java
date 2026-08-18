package exercicios17082026parte0.oo.exercicio1;

public abstract class Product implements Taxable {
    private final String productId;
    private String name;
    private double price;
    private ProductCategory category;

    public Product(String productId, String name, double price, ProductCategory category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public abstract void displayProductDetails();
}