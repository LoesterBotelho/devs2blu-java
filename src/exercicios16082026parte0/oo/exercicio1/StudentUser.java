package exercicios16082026parte0.oo.exercicio1;

public class StudentUser extends LibraryUser {
    private int borrowedLimit;

    public StudentUser(String cardId, String name, String email, int borrowedLimit) {
        super(cardId, name, email);
        this.borrowedLimit = borrowedLimit;
    }

    public int getBorrowedLimit() {
        return borrowedLimit;
    }

    @Override
    public void printUserType() {
        System.out.println("User Type: Student | Limit: " + borrowedLimit + " books");
    }

    @Override
    public void trackItem() {
        System.out.println("Tracking books borrowed by Student: " + getName());
    }
}