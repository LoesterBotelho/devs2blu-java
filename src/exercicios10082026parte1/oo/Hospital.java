package exercicios10082026parte1.oo;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private Long id;
    private String name;
    private String city;

    private final List<Patient> patients;
    private final List<Employee> employees;
    private final List<Appointment> appointments;

    public Hospital() {
        this.patients = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public Hospital(Long id, String name, String city) {
        this();

        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addEmployees(List<? extends Employee> employees) {
        this.employees.addAll(employees);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patients);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", patients=" + patients +
                ", employees=" + employees +
                ", appointments=" + appointments +
                '}';
    }
}