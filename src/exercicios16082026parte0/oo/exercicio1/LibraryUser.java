package exercicios16082026parte0.oo.exercicio1;

public abstract class LibraryUser implements Trackable {
    private final String cardId;
    private String name;
    private String email;

    public LibraryUser(String cardId, String name, String email) {
        this.cardId = cardId;
        this.name = name;
        this.email = email;
    }

    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public abstract void printUserType();
}