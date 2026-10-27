package exercicios27102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.Objects;

public class Doctor extends Person {

    private final MedicalSpecialty specialty;
    private final BigDecimal consultationPrice;

    public Doctor(
            long id,
            String name,
            String email,
            MedicalSpecialty specialty,
            BigDecimal consultationPrice) {

        super(id, name, email);

        this.specialty = Objects.requireNonNull(specialty);
        this.consultationPrice = Objects.requireNonNull(consultationPrice);

        if (consultationPrice.signum() < 0) {
            throw new IllegalArgumentException("Invalid consultation price");
        }
    }

    public MedicalSpecialty getSpecialty() {
        return specialty;
    }

    public BigDecimal getConsultationPrice() {
        return consultationPrice;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Specialty: " + specialty
                + " | Price: R$ " + consultationPrice;
    }
    
}