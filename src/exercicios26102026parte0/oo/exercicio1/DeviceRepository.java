package exercicios26102026parte0.oo.exercicio1;

public class DeviceRepository extends GenericRepository<SmartDevice> {
    public DeviceRepository() {
        super(SmartDevice::getId);
    }
}