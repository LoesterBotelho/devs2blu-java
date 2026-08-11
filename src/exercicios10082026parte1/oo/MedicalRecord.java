package exercicios10082026parte1.oo;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {

    private String diagnosis;
    private String notes;

    private final List<Appointment> appointments;
    private final List<Prescription> prescriptions;

    public MedicalRecord() {
        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public MedicalRecord(String diagnosis, String notes) {
        this();

        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }

    public List<Prescription> getPrescriptions() {
        return new ArrayList<>(prescriptions);
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "diagnosis='" + diagnosis + '\'' +
                ", notes='" + notes + '\'' +
                ", appointments=" + appointments +
                ", prescriptions=" + prescriptions +
                '}';
    }
}