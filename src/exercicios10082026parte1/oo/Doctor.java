package exercicios10082026parte1.oo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Doctor extends Employee {

    private DoctorSpecialty specialty;
    private BigDecimal consultationPrice;

    public Doctor() {
        super();
        this.category = "DOCTOR";
    }

    public Doctor(
            Long id,
            String name,
            String email,
            LocalDate birthDate,
            BigDecimal salary,
            String employeeCode,
            DoctorSpecialty specialty,
            BigDecimal consultationPrice) {

        super(
                id,
                name,
                email,
                birthDate,
                salary,
                employeeCode
        );

        this.specialty = specialty;
        this.consultationPrice = consultationPrice;
        this.category = "DOCTOR";
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public BigDecimal calculateBonus() {
        return getSalary().multiply(BigDecimal.valueOf(0.10));
    }

    public DoctorSpecialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(DoctorSpecialty specialty) {
        this.specialty = specialty;
    }

    public BigDecimal getConsultationPrice() {
        return consultationPrice;
    }

    public void setConsultationPrice(BigDecimal consultationPrice) {
        this.consultationPrice = consultationPrice;
    }

    public void prescribe(Medicine medicine) {
        System.out.println(
                getName() + " prescribed " + medicine.getName()
        );
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", specialty=" + specialty +
                ", consultationPrice=" + consultationPrice +
                ", salary=" + getSalary() +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}