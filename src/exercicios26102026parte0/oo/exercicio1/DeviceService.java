package exercicios26102026parte0.oo.exercicio1;

import java.util.List;

public class DeviceService {
	
    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public <T extends SmartDevice> T register(T device) {
        repository.save(device);
        return device;
    }

    public SmartDevice findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException(id));
    }

    public List<SmartDevice> findAll() {
        return repository.findAll();
    }

    public void turnOn(long id) {
        findById(id).turnOn();
    }

    public void turnOff(long id) {
        findById(id).turnOff();
    }

    public long nextId() {
        return IdGenerator.nextId();
    }
    
}