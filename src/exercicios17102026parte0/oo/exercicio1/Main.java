package exercicios17102026parte0.oo.exercicio1;


class Main {

	void main() {

        Book book = new Book(
                "B001",
                "Clean Code",
                "Robert C. Martin"
        );

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Type: " + book.getItemType());

        System.out.println("First borrow: " + book.borrow());
        System.out.println("Second borrow: " + book.borrow());
        System.out.println("Is borrowed: " + book.isBorrowed());

        System.out.println("Return: " + book.returnItem());
        System.out.println("Is borrowed: " + book.isBorrowed());
    }
}