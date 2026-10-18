package exercicios18102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class VehicleRepository {

    private final Map<String, Vehicle> vehiclesById = new HashMap<>();
    private final Set<String> registeredIds = new HashSet<>();

    public void save(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }

        if (!registeredIds.add(vehicle.getId())) {
            throw new IllegalArgumentException(
                    "Vehicle ID already exists: " + vehicle.getId());
        }

        vehiclesById.put(vehicle.getId(), vehicle);
    }

    public Optional<Vehicle> findById(String id) {
        return Optional.ofNullable(vehiclesById.get(id));
    }

    public List<Vehicle> findAll() {
        return new ArrayList<>(vehiclesById.values());
    }

    public boolean deleteById(String id) {
        Vehicle removed = vehiclesById.remove(id);

        if (removed == null) {
            return false;
        }

        registeredIds.remove(id);
        return true;
    }

    public int count() {
        return vehiclesById.size();
    }
}