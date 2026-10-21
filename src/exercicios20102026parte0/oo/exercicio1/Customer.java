package exercicios20102026parte0.oo.exercicio1;

public class Customer {
    private final long id;
    private final String name;

    public Customer(long id, String name) {
        if (id <= 0) throw new IllegalArgumentException("Customer ID must be positive.");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Customer name is required.");
        this.id = id;
        this.name = name;
    }

    public long getId() { return id; }
    public String getName() { return name; }
}
