package exercicios26102026parte0.oo.exercicio1;

public class SmartLight extends SmartDevice {

	private int brightness = 100;

    public SmartLight(long id, String name, Room room) {
        super(id, name, room);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
    	
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException(
                    "Brightness must be between 0 and 100");
        }
        
        this.brightness = brightness;
        
    }

    @Override
    public double getPowerWatts() {
        return isOn() ? 12.0 * brightness / 100.0 : 0.0;
    }

    @Override
    public String getDeviceType() {
        return "Smart Light";
    }
    
}