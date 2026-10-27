package exercicios26102026parte0.oo.exercicio1;

public class SmartSpeaker extends SmartDevice {
	
    private int volume = 30;

    public SmartSpeaker(long id, String name, Room room) {
        super(id, name, room);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException(
                    "Volume must be between 0 and 100");
        }
        this.volume = volume;
    }

    @Override
    public double getPowerWatts() {
        return isOn() ? 5.0 + volume * 0.1 : 0.0;
    }

    @Override
    public String getDeviceType() {
        return "Smart Speaker";
    }
    
}