package exercicios10082026parte1.oo;

import java.time.LocalDate;

public class Patient extends Person {

    private String healthInsurance;
    private MedicalRecord medicalRecord;

    public Patient() {
        super();
        this.category = "PATIENT";
    }

    public Patient(
            Long id,
            String name,
            String email,
            LocalDate birthDate,
            String healthInsurance) {

        super(id, name, email, birthDate);

        this.healthInsurance = healthInsurance;
        this.category = "PATIENT";
        this.medicalRecord = new MedicalRecord();
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public void addAppointment(Appointment appointment) {
        medicalRecord.addAppointment(appointment);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", birthDate=" + getBirthDate() +
                ", healthInsurance='" + healthInsurance + '\'' +
                ", medicalRecord=" + medicalRecord +
                '}';
    }
}