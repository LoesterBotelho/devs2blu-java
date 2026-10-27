package exercicios26102026parte0.oo.exercicio1;

public class SmartLock extends SmartDevice {
	
    private boolean locked = true;

    public SmartLock(long id, String name, Room room) {
        super(id, name, room);
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    @Override
    public double getPowerWatts() {
        return isOn() ? 3.0 : 0.0;
    }

    @Override
    public String getDeviceType() {
        return "Smart Lock";
    }
    
}