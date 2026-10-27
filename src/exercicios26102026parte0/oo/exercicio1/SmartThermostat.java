package exercicios26102026parte0.oo.exercicio1;

public class SmartThermostat extends SmartDevice {
	
    private double targetTemperature = 22.0;

    public SmartThermostat(long id, String name, Room room) {
        super(id, name, room);
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double temperature) {
        
    	if (temperature < 10 || temperature > 35) {
            throw new IllegalArgumentException(
                    "Temperature must be between 10 and 35");
        }
        
        targetTemperature = temperature;
    }

    @Override
    public double getPowerWatts() {
        return isOn() ? 900.0 : 0.0;
    }

    @Override
    public String getDeviceType() {
        return "Smart Thermostat";
    }
    
}