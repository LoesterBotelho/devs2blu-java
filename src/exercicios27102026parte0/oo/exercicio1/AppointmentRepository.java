package exercicios27102026parte0.oo.exercicio1;

public class AppointmentRepository extends GenericRepository<Appointment> {

    public AppointmentRepository() {
        super(Appointment::getId);
    }
    
}