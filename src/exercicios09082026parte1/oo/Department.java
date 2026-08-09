package exercicios09082026parte1.oo;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    private String name;
    private Manager manager;

    private final List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(
            Long id,
            String name,
            Manager manager) {

        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addEmployee(Employee employee, boolean notify) {

        employees.add(employee);

        if (notify) {
            System.out.println(
                    employee.getName() +
                    " added to " +
                    name
            );
        }
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return List.copyOf(employees);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                ", employees=" + employees.size() +
                '}';
    }
}
