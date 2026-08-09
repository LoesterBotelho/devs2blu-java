package exercicios09082026parte1.oo;

public class SeniorDeveloper extends Developer {

    private int yearsOfExperience;

    public SeniorDeveloper() {
        super();
    }

    public SeniorDeveloper(
            Long id,
            String name,
            String email,
            double salary,
            String employeeCode,
            String departmentName,
            String programmingLanguage,
            int yearsOfExperience) {

        super(
                id,
                name,
                email,
                salary,
                employeeCode,
                departmentName,
                programmingLanguage
        );

        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void work() {
        System.out.println(
                getName() +
                " is designing enterprise software."
        );
    }

    @Override
    public String getRole() {
        return "Senior Developer";
    }

    public void mentor() {
        System.out.println(
                getName() +
                " is mentoring developers."
        );
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "SeniorDeveloper{" +
                "name='" + getName() + '\'' +
                ", programmingLanguage='" +
                getProgrammingLanguage() + '\'' +
                ", yearsOfExperience=" +
                yearsOfExperience +
                ", salary=" + getSalary() +
                '}';
    }
}
