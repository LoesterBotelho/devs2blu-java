package exercicios10082026parte1.oo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescription implements Identifiable<Long> {

    private Long id;
    private Doctor doctor;
    private Patient patient;
    private LocalDate date;

    private final List<Medicine> medicines;

    public Prescription() {
        this.medicines = new ArrayList<>();
    }

    public Prescription(
            Long id,
            Doctor doctor,
            Patient patient,
            LocalDate date) {

        this();

        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public List<Medicine> getMedicines() {
        return new ArrayList<>(medicines);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", date=" + date +
                ", medicines=" + medicines +
                '}';
    }
}