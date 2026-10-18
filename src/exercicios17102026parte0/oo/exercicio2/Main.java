package exercicios17102026parte0.oo.exercicio2;

class Main {

	void main() {

        CatalogItem book = new Book(
                "B001",
                "Effective Java",
                "Programming",
                "Joshua Bloch"
        );

        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Category: " + book.getCategory());
    }
}