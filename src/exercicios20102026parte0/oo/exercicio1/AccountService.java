package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class AccountService {
    private final AccountRepository accounts;

    public AccountService(AccountRepository accounts) {
        this.accounts = accounts;
    }

    public FinancialAccount create(String name, BigDecimal openingBalance) {
        FinancialAccount account = new FinancialAccount(IdGenerator.nextId(), name, openingBalance);
        return accounts.save(account);
    }

    public FinancialAccount get(long id) {
        return accounts.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found: " + id));
    }

    public List<FinancialAccount> findAll() {
        return accounts.findAll();
    }
}
