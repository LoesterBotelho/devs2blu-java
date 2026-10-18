package exercicios18102026parte0.oo.exercicio1;

import java.util.Comparator;

public final class VehicleComparator {

    private VehicleComparator() {
    }

    public static Comparator<Vehicle> byDailyRate() {
        return Comparator.comparingDouble(Vehicle::getDailyRate);
    }

    public static Comparator<Vehicle> byYearDescending() {
        return Comparator.comparingInt(Vehicle::getYear).reversed();
    }

    public static Comparator<Vehicle> byBrandThenModel() {
        return Comparator.comparing(Vehicle::getBrand)
                .thenComparing(Vehicle::getModel);
    }
}