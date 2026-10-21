package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportService {
    private final TransactionService transactionService;

    public ReportService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public List<FinancialTransaction> filter(Predicate<FinancialTransaction> predicate) {
        return transactionService.findAll().stream().filter(predicate).toList();
    }

    public List<FinancialTransaction> filterWithRule(TransactionRule rule) {
        return transactionService.findAll().stream().filter(rule::test).toList();
    }

    public BigDecimal total(TransactionType type) {
        return transactionService.findAll().stream()
                .filter(transaction -> transaction.getType() == type)
                .map(FinancialTransaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<Category, BigDecimal> expensesByCategory() {
        return transactionService.findAll().stream()
                .filter(transaction -> transaction.getType() == TransactionType.EXPENSE)
                .collect(Collectors.groupingBy(
                        FinancialTransaction::getCategory,
                        Collectors.reducing(BigDecimal.ZERO, FinancialTransaction::getAmount, BigDecimal::add)));
    }
}
