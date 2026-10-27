package exercicios27102026parte0.oo.exercicio1;

public class PrescriptionRepository extends GenericRepository<Prescription> {

    public PrescriptionRepository() {
        super(Prescription::id);
    }
    
}