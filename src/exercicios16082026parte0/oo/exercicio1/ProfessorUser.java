package exercicios16082026parte0.oo.exercicio1;

public class ProfessorUser extends LibraryUser {
    private String facultyDepartment;

    public ProfessorUser(String cardId, String name, String email, String facultyDepartment) {
        super(cardId, name, email);
        this.facultyDepartment = facultyDepartment;
    }

    public String getFacultyDepartment() {
        return facultyDepartment;
    }

    @Override
    public void printUserType() {
        System.out.println("User Type: Professor | Department: " + facultyDepartment);
    }

    @Override
    public void trackItem() {
        System.out.println("Tracking reference materials for Professor: " + getName());
    }
}