package exercicios18102026parte0.oo.exercicio1;

public class Motorcycle extends Vehicle {

    private final int engineCapacityCc;

    public Motorcycle(
            String id,
            String brand,
            String model,
            int year,
            double dailyRate,
            int engineCapacityCc) {

        super(id, brand, model, year, dailyRate);

        if (engineCapacityCc < 1) {
            throw new IllegalArgumentException(
                    "Engine capacity must be positive.");
        }

        this.engineCapacityCc = engineCapacityCc;
    }

    public int getEngineCapacityCc() {
        return engineCapacityCc;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
}