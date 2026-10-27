package exercicios27102026parte0.oo.exercicio1;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment schedule(
            long id,
            Patient patient,
            Doctor doctor,
            LocalDateTime dateTime) {

        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "Appointment must be scheduled in the future");
        }

        boolean conflict = repository.findAll()
                .stream()
                .filter(appointment -> !appointment.isCancelled())
                .anyMatch(appointment ->
                        appointment.getDateTime().equals(dateTime)
                        && (appointment.getDoctor().equals(doctor)
                        || appointment.getPatient().equals(patient)));

        if (conflict) {
            throw new AppointmentConflictException(
                    "Doctor or patient already has an appointment at this time");
        }

        return repository.save(
                new Appointment(id, patient, doctor, dateTime));
    }

    public List<Appointment> findAll() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Appointment::getDateTime))
                .toList();
    }

    public List<Appointment> findByPatient(Patient patient) {
        return repository.findAll()
                .stream()
                .filter(appointment -> appointment.getPatient().equals(patient))
                .sorted(Comparator.comparing(Appointment::getDateTime))
                .toList();
    }

    public List<Appointment> findByDoctor(Doctor doctor) {
        return repository.findAll()
                .stream()
                .filter(appointment -> appointment.getDoctor().equals(doctor))
                .sorted(Comparator.comparing(Appointment::getDateTime))
                .toList();
    }

    public void cancel(long id) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Appointment not found: " + id));

        appointment.cancel();
    }

    public void complete(long id) {
        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Appointment not found: " + id));

        appointment.complete();
    }
    
}