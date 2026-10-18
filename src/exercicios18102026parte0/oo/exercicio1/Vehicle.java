package exercicios18102026parte0.oo.exercicio1;

public abstract class Vehicle implements Identifiable<String>, Rentable {

    private final String id;
    private final String brand;
    private final String model;
    private final int year;
    private final double dailyRate;
    private boolean available = true;

    protected Vehicle(
            String id,
            String brand,
            String model,
            int year,
            double dailyRate) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Vehicle ID is required.");
        }

        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand is required.");
        }

        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model is required.");
        }

        if (year < 1886) {
            throw new IllegalArgumentException("Invalid vehicle year.");
        }

        if (dailyRate < 0) {
            throw new IllegalArgumentException("Daily rate cannot be negative.");
        }

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void markAsRented() {
        if (!available) {
            throw new IllegalStateException("Vehicle is already rented.");
        }

        available = false;
    }

    @Override
    public void markAsReturned() {
        if (available) {
            throw new IllegalStateException("Vehicle is not currently rented.");
        }

        available = true;
    }

    public abstract String getVehicleType();

    @Override
    public String toString() {
        return "%s [%s] %s %s (%d)"
                .formatted(getVehicleType(), id, brand, model, year);
    }
}