package exercicios09082026parte1.oo;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private final List<Employee> employees = new ArrayList<>();

    public Manager() {
        super();
    }

    public Manager(
            Long id,
            String name,
            String email,
            double salary,
            String employeeCode,
            String departmentName) {

        super(
                id,
                name,
                email,
                salary,
                employeeCode,
                departmentName
        );
    }

    @Override
    public void work() {
        System.out.println(
                getName() +
                " is managing the development team."
        );
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return List.copyOf(employees);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", employees=" + employees.size() +
                '}';
    }
}
