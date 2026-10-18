package exercicios18102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FleetService {

    private final VehicleRepository vehicleRepository;

    public FleetService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> findAvailableUnder(double maxDailyRate) {
        return filterVehicles(
                vehicleRepository.findAll(),
                vehicle -> vehicle.isAvailable()
                        && vehicle.getDailyRate() < maxDailyRate
        );
    }

    public List<Vehicle> filterVehicles(
            List<? extends Vehicle> vehicles,
            Predicate<? super Vehicle> condition) {

        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (condition.test(vehicle)) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }
}