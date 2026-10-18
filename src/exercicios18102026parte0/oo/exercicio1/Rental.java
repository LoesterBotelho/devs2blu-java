package exercicios18102026parte0.oo.exercicio1;

public class Rental implements Identifiable<String> {

    private final String id;
    private final Customer customer;
    private final Vehicle vehicle;
    private final int days;
    private final double dailyRateAtRental;

    private RentalStatus status;

    public Rental(
            String id,
            Customer customer,
            Vehicle vehicle,
            int days) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Rental ID is required.");
        }

        if (customer == null || vehicle == null) {
            throw new IllegalArgumentException(
                    "Customer and vehicle are required.");
        }

        if (days < 1) {
            throw new IllegalArgumentException(
                    "Rental must be at least one day.");
        }

        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.dailyRateAtRental = vehicle.getDailyRate();
        this.status = RentalStatus.ACTIVE;
    }

    @Override
    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDays() {
        return days;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public double calculateTotal() {
        return dailyRateAtRental * days;
    }

    public void markAsReturned() {
        if (status == RentalStatus.RETURNED) {
            throw new IllegalStateException(
                    "Rental has already been returned.");
        }

        status = RentalStatus.RETURNED;
    }
}