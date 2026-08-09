package exercicios09082026parte1.oo;

public abstract class Person {

    private Long id;
    private String name;
    private String email;

    protected Person() {
    }

    protected Person(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract String getRole();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected String getBasicInfo() {
        return id + " - " + name + " - " + email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Person person)) {
            return false;
        }

        return id != null && id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}