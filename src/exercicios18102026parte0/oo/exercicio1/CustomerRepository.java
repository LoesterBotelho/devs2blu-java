package exercicios18102026parte0.oo.exercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomerRepository {

    private final Map<String, Customer> customersById = new HashMap<>();

    public void save(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        if (customersById.putIfAbsent(customer.getId(), customer) != null) {
            throw new IllegalArgumentException(
                    "Customer ID already exists: " + customer.getId());
        }
    }

    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customersById.get(id));
    }

    public int count() {
        return customersById.size();
    }
}