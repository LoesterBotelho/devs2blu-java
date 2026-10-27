package exercicios27102026parte0.oo.exercicio1;

import java.time.LocalDate;

public class Patient extends Person {

    private final LocalDate birthDate;
    private final String phone;

    public Patient(
            long id,
            String name,
            String email,
            LocalDate birthDate,
            String phone) {

        super(id, name, email);

        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid birth date");
        }

        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone is required");
        }

        this.birthDate = birthDate;
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return java.time.Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Age: " + getAge()
                + " | Phone: " + phone;
    }
    
}