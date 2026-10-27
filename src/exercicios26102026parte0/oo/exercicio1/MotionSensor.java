package exercicios26102026parte0.oo.exercicio1;

public class MotionSensor extends SmartDevice {
	
    private boolean motionDetected;

    public MotionSensor(long id, String name, Room room) {
        super(id, name, room);
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public void detectMotion() {
        motionDetected = true;
    }

    public void clearMotion() {
        motionDetected = false;
    }

    @Override
    public double getPowerWatts() {
        return isOn() ? 2.0 : 0.0;
    }

    @Override
    public String getDeviceType() {
        return "Motion Sensor";
    }
    
}