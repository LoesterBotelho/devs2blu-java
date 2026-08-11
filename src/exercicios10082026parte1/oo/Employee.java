package exercicios10082026parte1.oo;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

    private BigDecimal salary;

    protected String employeeCode;

    public Employee() {
        super();
    }

    public Employee(
            Long id,
            String name,
            String email,
            LocalDate birthDate,
            BigDecimal salary,
            String employeeCode) {

        super(id, name, email, birthDate);

        this.salary = salary;
        this.employeeCode = employeeCode;
        this.category = "EMPLOYEE";
    }

    public abstract BigDecimal calculateBonus();

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public BigDecimal calculateAnnualSalary() {
        return salary.multiply(BigDecimal.valueOf(12));
    }

    public BigDecimal calculateAnnualSalary(BigDecimal bonus) {
        return calculateAnnualSalary().add(bonus);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + salary +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}