package exercicios18102026parte0.oo.exercicio1;

public class Truck extends Vehicle {

    private final int loadCapacityKg;

    public Truck(
            String id,
            String brand,
            String model,
            int year,
            double dailyRate,
            int loadCapacityKg) {

        super(id, brand, model, year, dailyRate);

        if (loadCapacityKg < 1) {
            throw new IllegalArgumentException(
                    "Load capacity must be positive.");
        }

        this.loadCapacityKg = loadCapacityKg;
    }

    public int getLoadCapacityKg() {
        return loadCapacityKg;
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }
}