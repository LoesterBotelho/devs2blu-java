package exercicios26102026parte0.oo.exercicio1;

public abstract class SmartDevice {
	
    private final long id;
    private final String name;
    private final Room room;
    private DeviceStatus status = DeviceStatus.OFF;

    protected SmartDevice(long id, String name, Room room) {
    	
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid device ID");
        }
        
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Device name is required");
        }
        
        this.id = id;
        this.name = name;
        this.room = java.util.Objects.requireNonNull(room);
        
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public boolean isOn() {
        return status == DeviceStatus.ON;
    }

    public void turnOn() {
        status = DeviceStatus.ON;
    }

    public void turnOff() {
        status = DeviceStatus.OFF;
    }

    public abstract double getPowerWatts();

    public abstract String getDeviceType();

    @Override
    public String toString() {
        return "%s #%d | %s | %s | %.1f W".formatted(
                getDeviceType(), id, name, status, getPowerWatts());
    }
    
    
}