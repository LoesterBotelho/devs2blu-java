package exercicios16082026parte0.oo.exercicio1;

public class LoanTransaction {
    private final String transactionId;
    private LibraryUser user;
    private Book book;

    public LoanTransaction(String transactionId, LibraryUser user, Book book) {
        this.transactionId = transactionId;
        this.user = user;
        this.book = book;
    }

    public void executeLoan() {
        if (book.getStatus() == LoanStatus.AVAILABLE) {
            book.setStatus(LoanStatus.BORROWED);
            System.out.println("Loan " + transactionId + " successful for " + user.getName() + " taking " + book.getTitle());
        } else {
            System.out.println("Loan " + transactionId + " failed. Book is unavailable.");
        }
    }
}