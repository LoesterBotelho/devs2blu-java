package exercicios09082026parte1.oo;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private Long id;
    private String name;
    private Customer customer;

    private final List<Employee> team = new ArrayList<>();

    public Project() {
    }

    public Project(
            Long id,
            String name,
            Customer customer) {

        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public void addEmployee(Employee employee) {
        team.add(employee);
    }

    public void addEmployee(Employee... employees) {

        for (Employee employee : employees) {
            team.add(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        team.remove(employee);
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Employee> getTeam() {
        return List.copyOf(team);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customer=" + customer.getName() +
                ", teamSize=" + team.size() +
                '}';
    }
}
