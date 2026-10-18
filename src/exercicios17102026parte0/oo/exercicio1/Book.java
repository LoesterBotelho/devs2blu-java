package exercicios17102026parte0.oo.exercicio1;

public class Book extends LibraryItem implements Borrowable {

    private final String author;
    private boolean borrowed;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
        this.borrowed = false;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public boolean borrow() {
        if (borrowed) {
            return false;
        }

        borrowed = true;
        return true;
    }

    @Override
    public boolean returnItem() {
        if (!borrowed) {
            return false;
        }

        borrowed = false;
        return true;
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}