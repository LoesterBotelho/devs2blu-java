package exercicios27102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final String DIV = "-------------------------------------------------------------------------------------------";
        
        // -------------------------------------------------------------------------------------------

        var patientService = new PatientService(new PatientRepository());
        var doctorService = new DoctorService(new DoctorRepository());
        var appointmentService = new AppointmentService(new AppointmentRepository());
        var reportService = new ReportService();

        // -------------------------------------------------------------------------------------------

        var patient1 = patientService.register(
                new Patient(
                        IdGenerator.nextId(),
                        "Ana Silva",
                        "ana@example.com",
                        LocalDate.of(1995, 5, 12),
                        "47999990001"));

        var patient2 = patientService.register(
                new Patient(
                        IdGenerator.nextId(),
                        "Carlos Souza",
                        "carlos@example.com",
                        LocalDate.of(1982, 9, 20),
                        "47999990002"));

        var patient3 = patientService.register(
                new Patient(
                        IdGenerator.nextId(),
                        "Mariana Costa",
                        "mariana@example.com",
                        LocalDate.of(2010, 3, 8),
                        "47999990003"));

        // -------------------------------------------------------------------------------------------

        var doctor1 = doctorService.register(
                new Doctor(
                        IdGenerator.nextId(),
                        "Roberto Lima",
                        "roberto@example.com",
                        MedicalSpecialty.CARDIOLOGY,
                        new BigDecimal("250.00")));

        var doctor2 = doctorService.register(
                new Doctor(
                        IdGenerator.nextId(),
                        "Fernanda Alves",
                        "fernanda@example.com",
                        MedicalSpecialty.PEDIATRICS,
                        new BigDecimal("180.00")));

        var doctor3 = doctorService.register(
                new Doctor(
                        IdGenerator.nextId(),
                        "Paulo Mendes",
                        "paulo@example.com",
                        MedicalSpecialty.DERMATOLOGY,
                        new BigDecimal("220.00")));

        // -------------------------------------------------------------------------------------------

        var appointment1 = appointmentService.schedule(
                IdGenerator.nextId(),
                patient1,
                doctor1,
                LocalDateTime.now().plusDays(1)
                        .withHour(9).withMinute(0).withSecond(0).withNano(0));

        var appointment2 = appointmentService.schedule(
                IdGenerator.nextId(),
                patient2,
                doctor2,
                LocalDateTime.now().plusDays(3)
                        .withHour(10).withMinute(0).withSecond(0).withNano(0));

        var appointment3 = appointmentService.schedule(
                IdGenerator.nextId(),
                patient3,
                doctor2,
                LocalDateTime.now().plusDays(3)
                        .withHour(11).withMinute(0).withSecond(0).withNano(0));

        var appointment4 = appointmentService.schedule(
                IdGenerator.nextId(),
                patient3,
                doctor3,
                LocalDateTime.now().plusDays(3)
                        .withHour(14).withMinute(0).withSecond(0).withNano(0));

        // -------------------------------------------------------------------------------------------

        appointment1.complete();
        appointment4.complete();

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("HOSPITAL MANAGEMENT SYSTEM");

        IO.println("\nREGISTERED PATIENTS");
        patientService.findAll().forEach(IO::println);

        IO.println("\nREGISTERED DOCTORS");
        doctorService.findAll().forEach(IO::println);

        IO.println("\nCARDIOLOGY DOCTORS");
        doctorService.findBySpecialty(MedicalSpecialty.CARDIOLOGY)
                .forEach(IO::println);

        IO.println("\nPATIENT SEARCH");
        patientService.searchByName("ana").forEach(IO::println);

        IO.println("\nADULT PATIENTS");
        patientService.findAdults().forEach(IO::println);

        IO.println("\nALL APPOINTMENTS");
        appointmentService.findAll().forEach(IO::println);

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("\nFUNCTIONAL INTERFACES");

        EntityPredicate<Patient> adultPredicate =
                patient -> patient.getAge() >= 18;

        EntityAction<Patient> patientPrinter =
                patient -> IO.println(patient.getName());

        EntityMapper<Patient, String> patientNameMapper =
                Patient::getName;

        patientService.findAll().stream()
                .filter(adultPredicate::test)
                .forEach(patientPrinter::execute);

        List<String> patientNames = patientService.findAll().stream()
                .map(patientNameMapper::map)
                .toList();

        IO.println("\nPATIENT NAMES");
        patientNames.forEach(IO::println);

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("\nREPORTS");
        IO.println("Total patients: "
                + reportService.countPatients(patientService.findAll()));

        IO.println("Total doctors: "
                + reportService.countDoctors(doctorService.findAll()));

        IO.println("Completed appointments: "
                + reportService.countCompletedAppointments(appointmentService.findAll()));

        IO.println("Pending appointments: "
                + reportService.findPendingAppointments(appointmentService.findAll()).size());

        IO.println("Potential revenue: R$ "
                + reportService.calculatePotentialRevenue(appointmentService.findAll()));

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("\nAPPOINTMENTS BY DOCTOR");
        reportService.countAppointmentsByDoctor(appointmentService.findAll())
                .forEach((doctor, count) ->
                        IO.println(doctor + ": " + count));

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("\nDOCTORS WITH CONSULTATION UP TO R$ 220.00");
        doctorService.findWithinBudget(new BigDecimal("220.00"))
                .forEach(IO::println);

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("\nAPPOINTMENT CONFLICT TEST");

        try {
            appointmentService.schedule(
                    IdGenerator.nextId(),
                    patient2,
                    doctor2,
                    appointment2.getDateTime());
        } catch (AppointmentConflictException exception) {
            IO.println(exception.getMessage());
        }

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("\nCANCEL APPOINTMENT");
        appointmentService.cancel(appointment3.getId());
        IO.println("Cancelled: " + appointment3.isCancelled());

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------

        IO.println("\nFINAL REPORT");
        IO.println("Completed: "
                + reportService.countCompletedAppointments(appointmentService.findAll()));

        IO.println("Cancelled: "
                + reportService.countCancelledAppointments(appointmentService.findAll()));

        IO.println("Pending: "
                + reportService.findPendingAppointments(appointmentService.findAll()).size());

        IO.println(DIV);
        // -------------------------------------------------------------------------------------------
    }
}