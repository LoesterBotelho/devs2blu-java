package exercicios27102026parte0.oo.exercicio1;

public class MedicalRecordRepository extends GenericRepository<MedicalRecord> {

    public MedicalRecordRepository() {
        super(MedicalRecord::id);
    }
    
}