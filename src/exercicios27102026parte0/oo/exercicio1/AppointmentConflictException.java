package exercicios27102026parte0.oo.exercicio1;

public class AppointmentConflictException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AppointmentConflictException(String message) {
        super(message);
    }
}