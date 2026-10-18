package exercicios17102026parte0.oo.exercicio1;

public abstract class LibraryItem {

    private final String id;
    private final String title;

    protected LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getItemType();
}