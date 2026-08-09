package exercicios09082026parte1.oo;

public abstract class Employee extends Person implements Payable, Reportable {

    private double salary;
    protected String employeeCode;
    String departmentName;

    public Employee() {
        super();
    }

    public Employee(
            Long id,
            String name,
            String email,
            double salary,
            String employeeCode,
            String departmentName) {

        super(id, name, email);

        this.salary = salary;
        this.employeeCode = employeeCode;
        this.departmentName = departmentName;
    }

    public abstract void work();

    @Override
    public double calculateSalary() {
        return salary;
    }

    public double calculateSalary(double bonus) {
        return salary + bonus;
    }

    public double calculateSalary(double bonus, double commission) {
        return salary + bonus + commission;
    }

    @Override
    public void generateReport() {
        printReportHeader();

        System.out.println("Employee: " + getName());
        System.out.println("Role: " + getRole());
        System.out.println("Salary: " + calculateSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", salary=" + salary +
                ", employeeCode='" + employeeCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}