package exercicios10082026parte1.oo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Hospital hospital = new Hospital(1L, "Central Hospital", "Blumenau");

		Patient patient = new Patient(1L, "Heloisa", "Heloisa@example.com", LocalDate.of(1990, 5, 10), "Health Plus");

		patient.getMedicalRecord().setDiagnosis("Hypertension");

		patient.getMedicalRecord().setNotes("Patient needs regular monitoring");
		
		Doctor doctor = new Doctor(2L, "Alice", "alice@hospital.com", LocalDate.of(1985, 3, 20), new BigDecimal("15000.00"), "DOC001", DoctorSpecialty.CARDIOLOGY, new BigDecimal("350.00"));

		Nurse nurse = new Nurse(3L, "Maria", "maria@hospital.com", LocalDate.of(1992, 8, 15), new BigDecimal("7000.00"), "NUR001", "NUR123456");

		Medicine medicine1 = new Medicine(1L, "Medicine A", new BigDecimal("25.90"));

		Medicine medicine2 = new Medicine(2L, "Medicine B", new BigDecimal("40.50"));

		Appointment appointment = new Appointment(1L, patient, doctor, LocalDateTime.of(2026, 8, 15, 14, 30));

		Prescription prescription = new Prescription(1L, doctor, patient, LocalDate.now());

		prescription.addMedicine(medicine1);
		prescription.addMedicine(medicine2);

		patient.getMedicalRecord().addAppointment(appointment);

		patient.getMedicalRecord().addPrescription(prescription);

		hospital.addPatient(patient);
		hospital.addAppointment(appointment);

		List<Employee> employees = new ArrayList<>();

		employees.add(doctor);
		employees.add(nurse);

		hospital.addEmployees(employees);

		System.out.println(patient);
		System.out.println();

		System.out.println(doctor);
		System.out.println();

		System.out.println(nurse);
		System.out.println();

		System.out.println(appointment);
		System.out.println();

		System.out.println(prescription);
		System.out.println();

		System.out.println(hospital);
		System.out.println();

		Employee employee1 = doctor;
		Employee employee2 = nurse;

		System.out.println(employee1.getRole());
		System.out.println(employee2.getRole());

		System.out.println(employee1.calculateBonus());

		System.out.println(employee2.calculateBonus());

		if (employee1 instanceof Doctor doctorEmployee) {
			System.out.println(doctorEmployee.getSpecialty());
		}

		if (employee2 instanceof Nurse nurseEmployee) {
			System.out.println(nurseEmployee.getRegistrationNumber());
		}

		Person person1 = patient;
		Person person2 = doctor;
		Person person3 = nurse;

		System.out.println(person1.getRole());
		System.out.println(person2.getRole());
		System.out.println(person3.getRole());

		Payment payment1 = new CreditCardPayment(1L, new BigDecimal("350.00"), "PAY001", "Heloisa", "1234");
		Payment payment2 = new PixPayment(2L, new BigDecimal("250.00"), "PAY002", "loester@example.com");

		List<Payment> payments = new ArrayList<>();

		payments.add(payment1);
		payments.add(payment2);

		for (Payment payment : payments) {
			System.out.println(payment.getPaymentType());
			System.out.println(payment.calculateAmount());
			System.out.println(payment.isFree());
		}

		Repository<Patient> patientRepository = new Repository<>();
		Repository<Doctor> doctorRepository = new Repository<>();

		patientRepository.save(patient);
		doctorRepository.save(doctor);

		System.out.println();
		System.out.println(patientRepository.findById(1L));
		System.out.println(doctorRepository.findById(2L));
		System.out.println(patientRepository.findAll());
		System.out.println(doctorRepository.findAll());
		System.out.println(patient.equals(patient));
		System.out.println(medicine1.equals(medicine2));
		System.out.println(medicine1.hashCode());
		System.out.println(doctor.calculateAnnualSalary());
		System.out.println(doctor.calculateAnnualSalary(doctor.calculateBonus()));
		
		
		System.out.println();
		System.out.println(patient.toString());
		System.out.println(doctor.toString());
		System.out.println(nurse.toString());
		System.out.println(medicine1.toString());
		System.out.println(medicine2.toString());
		System.out.println(appointment.toString());
		System.out.println(prescription.toString());
		System.out.println(patient.getMedicalRecord().toString());
		System.out.println(payment1.toString());
		System.out.println(payment2.toString());
		System.out.println(hospital.toString());
		System.out.println(patientRepository.toString());
		System.out.println(doctorRepository.toString());
		
		
		System.out.println();		
		System.out.println(patient instanceof Patient);
		System.out.println(patient instanceof Person);
		System.out.println(doctor instanceof Doctor);
		System.out.println(doctor instanceof Employee);
		System.out.println(doctor instanceof Person);
		System.out.println(nurse instanceof Nurse);
		System.out.println(nurse instanceof Employee);
		System.out.println(nurse instanceof Person);		
		

			
	}

}
