package exercicios18102026parte0.oo.exercicio1;

public class Customer implements Identifiable<String> {

    private final String id;
    private final String name;
    private final String email;

    public Customer(String id, String name, String email) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Customer ID is required.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name is required.");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("A valid email is required.");
        }

        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "%s (%s)".formatted(name, email);
    }
}