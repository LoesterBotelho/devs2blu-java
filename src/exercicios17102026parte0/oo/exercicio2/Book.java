package exercicios17102026parte0.oo.exercicio2;

public class Book implements CatalogItem {

    private final String id;
    private final String title;
    private final String category;
    private final String author;

    public Book(
            String id,
            String title,
            String category,
            String author) {

        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }
}