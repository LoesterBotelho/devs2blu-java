package exercicios27102026parte0.oo.exercicio1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {

    private final long id;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDateTime dateTime;
    private boolean completed;
    private boolean cancelled;

    public Appointment(
            long id,
            Patient patient,
            Doctor doctor,
            LocalDateTime dateTime) {

        if (id <= 0) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        this.id = id;
        this.patient = Objects.requireNonNull(patient);
        this.doctor = Objects.requireNonNull(doctor);
        this.dateTime = Objects.requireNonNull(dateTime);
    }

    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void complete() {
        if (cancelled) {
            throw new IllegalStateException("Cancelled appointment cannot be completed");
        }

        completed = true;
    }

    public void cancel() {
        if (completed) {
            throw new IllegalStateException("Completed appointment cannot be cancelled");
        }

        cancelled = true;
    }

    @Override
    public String toString() {
        return "Appointment #%d | Patient: %s | Doctor: %s | Date: %s | Completed: %s | Cancelled: %s"
                .formatted(
                        id,
                        patient.getName(),
                        doctor.getName(),
                        dateTime,
                        completed,
                        cancelled);
    }
    
}