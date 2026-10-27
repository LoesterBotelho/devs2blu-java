package exercicios27102026parte0.oo.exercicio1;

import java.time.LocalDateTime;
import java.util.Objects;

public record MedicalRecord(
		
        long id,
        Patient patient,
        Doctor doctor,
        LocalDateTime date,
        String diagnosis,
        String notes) {

    public MedicalRecord {
    	
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid record ID");
        }

        Objects.requireNonNull(patient);
        Objects.requireNonNull(doctor);
        Objects.requireNonNull(date);

        if (diagnosis == null || diagnosis.isBlank()) {
            throw new IllegalArgumentException("Diagnosis is required");
        }

        if (notes == null || notes.isBlank()) {
            throw new IllegalArgumentException("Notes are required");
        }
        
    }
    
}