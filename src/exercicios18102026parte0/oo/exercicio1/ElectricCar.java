package exercicios18102026parte0.oo.exercicio1;

public class ElectricCar extends Car {

    private final double batteryCapacityKwh;

    public ElectricCar(
            String id,
            String brand,
            String model,
            int year,
            double dailyRate,
            int passengerCapacity,
            double batteryCapacityKwh) {

        super(id, brand, model, year, dailyRate, passengerCapacity);

        if (batteryCapacityKwh <= 0) {
            throw new IllegalArgumentException(
                    "Battery capacity must be positive.");
        }

        this.batteryCapacityKwh = batteryCapacityKwh;
    }

    public double getBatteryCapacityKwh() {
        return batteryCapacityKwh;
    }

    @Override
    public String getVehicleType() {
        return "Electric car";
    }
}