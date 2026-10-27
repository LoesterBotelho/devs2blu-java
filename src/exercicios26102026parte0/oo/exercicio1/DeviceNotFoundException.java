package exercicios26102026parte0.oo.exercicio1;

public class DeviceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeviceNotFoundException(long id) {
        super("Device not found: " + id);
    }
}