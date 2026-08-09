package exercicios09082026parte1.oo;

public class Developer extends Employee {

    private String programmingLanguage;

    public Developer() {
        super();
    }

    public Developer(
            Long id,
            String name,
            String email,
            double salary,
            String employeeCode,
            String departmentName,
            String programmingLanguage) {

        super(
                id,
                name,
                email,
                salary,
                employeeCode,
                departmentName
        );

        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(
                getName() +
                " is developing software using " +
                programmingLanguage
        );
    }

    @Override
    public String getRole() {
        return "Developer";
    }

    public void writeCode() {
        System.out.println(getName() + " is writing code.");
    }

    public void writeCode(String projectName) {
        System.out.println(
                getName() +
                " is writing code for " +
                projectName
        );
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + getName() + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}