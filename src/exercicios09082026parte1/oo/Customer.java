package exercicios09082026parte1.oo;

public class Customer extends Person {

    private String companyName;

    public Customer() {
        super();
    }

    public Customer(
            Long id,
            String name,
            String email,
            String companyName) {

        super(id, name, email);

        this.companyName = companyName;
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    public void requestProject() {
        System.out.println(
                companyName +
                " requested a new project."
        );
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}