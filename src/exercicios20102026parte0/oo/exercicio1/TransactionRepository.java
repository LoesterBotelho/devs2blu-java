package exercicios20102026parte0.oo.exercicio1;

public class TransactionRepository extends InMemoryRepository<FinancialTransaction> {
    public TransactionRepository() {
        super(FinancialTransaction::getId);
    }
}
