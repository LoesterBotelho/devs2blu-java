package exercicios26102026parte0.oo.exercicio1;

public class SmartCamera extends SmartDevice {
	
    private boolean recording;

    public SmartCamera(long id, String name, Room room) {
        super(id, name, room);
    }

    public boolean isRecording() {
        return recording;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        recording = true;
    }

    @Override
    public void turnOff() {
        super.turnOff();
        recording = false;
    }

    @Override
    public double getPowerWatts() {
        return isOn() ? 8.0 : 0.0;
    }

    @Override
    public String getDeviceType() {
        return "Smart Camera";
    }
    
}