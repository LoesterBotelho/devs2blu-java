package exercicios27102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReportService {

    public long countPatients(List<Patient> patients) {
        return patients.size();
    }

    public long countDoctors(List<Doctor> doctors) {
        return doctors.size();
    }

    public long countCompletedAppointments(List<Appointment> appointments) {
        return appointments.stream()
                .filter(Appointment::isCompleted)
                .count();
    }

    public long countCancelledAppointments(List<Appointment> appointments) {
        return appointments.stream()
                .filter(Appointment::isCancelled)
                .count();
    }

    public List<Appointment> findPendingAppointments(
            List<Appointment> appointments) {

        return appointments.stream()
                .filter(appointment -> !appointment.isCompleted())
                .filter(appointment -> !appointment.isCancelled())
                .toList();
    }

    public Map<String, Long> countAppointmentsByDoctor(
            List<Appointment> appointments) {

        return appointments.stream()
                .filter(appointment -> !appointment.isCancelled())
                .collect(Collectors.groupingBy(
                        appointment -> appointment.getDoctor().getName(),
                        Collectors.counting()));
    }

    public Map<String, List<Appointment>> groupAppointmentsByDoctor(
            List<Appointment> appointments) {

        return appointments.stream()
                .filter(appointment -> !appointment.isCancelled())
                .collect(Collectors.groupingBy(
                        appointment -> appointment.getDoctor().getName()));
    }

    public BigDecimal calculatePotentialRevenue(
            List<Appointment> appointments) {

        return appointments.stream()
                .filter(appointment -> !appointment.isCancelled())
                .map(appointment ->
                        appointment.getDoctor().getConsultationPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public <T, R> List<R> transform(
            List<T> entities,
            Function<T, R> mapper) {

        return entities.stream()
                .map(mapper)
                .toList();
    }
    
}