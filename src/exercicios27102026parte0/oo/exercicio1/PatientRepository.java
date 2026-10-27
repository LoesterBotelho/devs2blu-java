package exercicios27102026parte0.oo.exercicio1;

public class PatientRepository extends GenericRepository<Patient> {

    public PatientRepository() {
        super(Patient::getId);
    }
    
}
