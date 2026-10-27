package exercicios26102026parte0.oo.exercicio1;

import java.util.List;

public class EnergyService {
	
    public double totalPowerWatts(List<SmartDevice> devices) {
        return devices.stream()
                .filter(SmartDevice::isOn)
                .mapToDouble(SmartDevice::getPowerWatts)
                .sum();
    }

    public double estimatedEnergyKwh(
            List<SmartDevice> devices,
            double hours) {

        if (!Double.isFinite(hours) || hours < 0) {
            throw new IllegalArgumentException(
                    "Hours must be a finite non-negative number");
        }

        return totalPowerWatts(devices) * hours / 1000.0;
    }

    public long countActiveDevices(List<SmartDevice> devices) {
        return devices.stream()
                .filter(SmartDevice::isOn)
                .count();
    }
    
}