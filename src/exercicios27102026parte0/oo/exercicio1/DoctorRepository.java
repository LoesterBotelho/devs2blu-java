package exercicios27102026parte0.oo.exercicio1;

public class DoctorRepository extends GenericRepository<Doctor> {

    public DoctorRepository() {
        super(Doctor::getId);
    }
    
}