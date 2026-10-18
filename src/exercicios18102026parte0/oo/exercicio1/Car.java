package exercicios18102026parte0.oo.exercicio1;

public class Car extends Vehicle {

    private final int passengerCapacity;

    public Car(
            String id,
            String brand,
            String model,
            int year,
            double dailyRate,
            int passengerCapacity) {

        super(id, brand, model, year, dailyRate);

        if (passengerCapacity < 1) {
            throw new IllegalArgumentException(
                    "Passenger capacity must be positive.");
        }

        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}