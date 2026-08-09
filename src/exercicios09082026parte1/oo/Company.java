package exercicios09082026parte1.oo;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private Long id;
    private String name;
    private Address address;

    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();

    public Company() {
    }

    public Company(
            Long id,
            String name,
            Address address) {

        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void printEmployees() {

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void printProjects() {

        for (Project project : projects) {
            System.out.println(project);
        }
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return List.copyOf(employees);
    }

    public List<Project> getProjects() {
        return List.copyOf(projects);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", employees=" + employees.size() +
                ", projects=" + projects.size() +
                '}';
    }
}