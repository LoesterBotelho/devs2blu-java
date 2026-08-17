package exercicios16082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private String libraryBranch;
    private List<Book> books;

    public LibraryCatalog(String libraryBranch) {
        this.libraryBranch = libraryBranch;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayCatalog() {
        System.out.println("Catalog for Branch: " + libraryBranch);
        for (Book b : books) {
            System.out.println("- " + b.getTitle() + " [" + b.getGenre() + "] status: " + b.getStatus());
        }
    }
}