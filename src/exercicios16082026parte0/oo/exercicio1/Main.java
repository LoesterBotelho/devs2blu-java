package exercicios16082026parte0.oo.exercicio1;

public class Main {
    public static void main(String[] args) {
        StudentUser student = new StudentUser("ST-01", "Lucas", "lucas@email.com", 3);
        ProfessorUser professor = new ProfessorUser("PR-01", "Dr. Helena", "helena@email.com", "Computer Science");

        student.printUserType();
        professor.printUserType();

        Book book = new Book("978-3-16-148410-0", "Advanced Java Concepts", BookGenre.TECHNOLOGY, LoanStatus.AVAILABLE);

        LibraryCatalog catalog = new LibraryCatalog("Central Library");
        catalog.addBook(book);

        LoanTransaction transaction = new LoanTransaction("TR-1001", student, book);
        transaction.executeLoan();

        student.trackItem();
        catalog.displayCatalog();
    }
}