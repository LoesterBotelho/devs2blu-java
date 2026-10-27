package exercicios27102026parte0.oo.exercicio1;

import java.time.LocalDate;
import java.util.Objects;

public record Prescription(
		
        long id,
        Patient patient,
        Doctor doctor,
        String medication,
        String dosage,
        LocalDate startDate,
        LocalDate endDate) {

    public Prescription {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid prescription ID");
        }

        Objects.requireNonNull(patient);
        Objects.requireNonNull(doctor);
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);

        if (medication == null || medication.isBlank()) {
            throw new IllegalArgumentException("Medication is required");
        }

        if (dosage == null || dosage.isBlank()) {
            throw new IllegalArgumentException("Dosage is required");
        }

        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Invalid prescription period");
        }
    }

    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return !today.isBefore(startDate) && !today.isAfter(endDate);
    }
    
}