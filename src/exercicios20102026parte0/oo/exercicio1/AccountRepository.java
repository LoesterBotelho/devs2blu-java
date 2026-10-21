package exercicios20102026parte0.oo.exercicio1;

public class AccountRepository extends InMemoryRepository<FinancialAccount> {
    public AccountRepository() {
        super(FinancialAccount::getId);
    }
}
