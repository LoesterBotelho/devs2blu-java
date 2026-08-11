package exercicios10082026parte1.oo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Nurse extends Employee {

    private String registrationNumber;

    public Nurse() {
        super();
        this.category = "NURSE";
    }

    public Nurse(
            Long id,
            String name,
            String email,
            LocalDate birthDate,
            BigDecimal salary,
            String employeeCode,
            String registrationNumber) {

        super(
                id,
                name,
                email,
                birthDate,
                salary,
                employeeCode
        );

        this.registrationNumber = registrationNumber;
        this.category = "NURSE";
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    @Override
    public BigDecimal calculateBonus() {
        return getSalary().multiply(BigDecimal.valueOf(0.05));
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", salary=" + getSalary() +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}