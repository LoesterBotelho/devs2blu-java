package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TransactionService {
    private final AccountService accountService;
    private final TransactionRepository transactions;

    public TransactionService(AccountService accountService, TransactionRepository transactions) {
        this.accountService = accountService;
        this.transactions = transactions;
    }

    public FinancialTransaction register(long accountId, TransactionType type, Category category,
            BigDecimal amount, String description, LocalDate date) {
        FinancialAccount account = accountService.get(accountId);
        if (type == TransactionType.INCOME) {
            account.credit(amount);
        } else {
            account.debit(amount);
        }
        FinancialTransaction transaction = new FinancialTransaction(
                IdGenerator.nextId(), accountId, type, category, amount, description, date);
        return transactions.save(transaction);
    }

    public List<FinancialTransaction> findAll() {
        return transactions.findAll();
    }
}
