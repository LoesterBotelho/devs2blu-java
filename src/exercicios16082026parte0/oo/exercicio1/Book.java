package exercicios16082026parte0.oo.exercicio1;

public class Book {
    private final String isbn;
    private String title;
    private BookGenre genre;
    private LoanStatus status;

    public Book(String isbn, String title, BookGenre genre, LoanStatus status) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}