package exercicios18102026parte0.oo.exercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RentalService {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;
    private final Map<String, Rental> rentalsById = new HashMap<>();

    public RentalService(
            VehicleRepository vehicleRepository,
            CustomerRepository customerRepository) {

        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }

    public Rental rent(
            String rentalId,
            String customerId,
            String vehicleId,
            int days) {

        if (rentalsById.containsKey(rentalId)) {
            throw new IllegalArgumentException(
                    "Rental ID already exists: " + rentalId);
        }

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Customer not found: " + customerId));

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Vehicle not found: " + vehicleId));

        Rental rental = new Rental(rentalId, customer, vehicle, days);

        vehicle.markAsRented();
        rentalsById.put(rentalId, rental);

        return rental;
    }

    public void returnVehicle(String rentalId) {
        Rental rental = Optional.ofNullable(rentalsById.get(rentalId))
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Rental not found: " + rentalId));

        rental.markAsReturned();
        rental.getVehicle().markAsReturned();
    }

    public Optional<Rental> findById(String rentalId) {
        return Optional.ofNullable(rentalsById.get(rentalId));
    }
}