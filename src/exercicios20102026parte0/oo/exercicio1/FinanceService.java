package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FinanceService {
    private FinanceService() {}

    public static void runDemo() {
    	
        AccountRepository accountRepository = new AccountRepository();
        TransactionRepository transactionRepository = new TransactionRepository();
        BudgetRepository budgetRepository = new BudgetRepository();

        AccountService accountService = new AccountService(accountRepository);
        TransactionService transactionService = new TransactionService(accountService, transactionRepository);
        BudgetService budgetService = new BudgetService(budgetRepository);
        ReportService reportService = new ReportService(transactionService);

        FinancialAccount account = accountService.create("Conta principal", new BigDecimal("1500.00"));

        transactionService.register(account.getId(), TransactionType.INCOME, Category.SALARY,
                new BigDecimal("3200.00"), "Salário", LocalDate.now());
        transactionService.register(account.getId(), TransactionType.EXPENSE, Category.FOOD,
                new BigDecimal("185.90"), "Compras do mercado", LocalDate.now());
        transactionService.register(account.getId(), TransactionType.EXPENSE, Category.TRANSPORT,
                new BigDecimal("75.00"), "Combustível", LocalDate.now());
        transactionService.register(account.getId(), TransactionType.EXPENSE, Category.HEALTH,
                new BigDecimal("120.00"), "Farmácia", LocalDate.now());

        budgetService.create(Category.FOOD, new BigDecimal("600.00"));

        ConsolePrinter.title("Sistema de Gestão Financeira — Java 25");
        ConsolePrinter.line("Conta: " + account.getName());
        ConsolePrinter.line("Saldo atual: " + MoneyFormatter.format(account.getBalance()));
        ConsolePrinter.line("Total de receitas: " + MoneyFormatter.format(reportService.total(TransactionType.INCOME)));
        ConsolePrinter.line("Total de despesas: " + MoneyFormatter.format(reportService.total(TransactionType.EXPENSE)));

        ConsolePrinter.title("Despesas por categoria");
        Map<Category, BigDecimal> expenses = reportService.expensesByCategory();
        expenses.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> ConsolePrinter.line(
                        entry.getKey() + ": " + MoneyFormatter.format(entry.getValue())));

        ConsolePrinter.title("Transações acima de R$ 100,00 (Lambda + Predicate)");
        List<FinancialTransaction> expensiveTransactions =
                reportService.filter(transaction -> transaction.getAmount().compareTo(new BigDecimal("100.00")) > 0);
        expensiveTransactions.stream()
                .sorted(Comparator.comparing(FinancialTransaction::getAmount).reversed())
                .forEach(transaction -> ConsolePrinter.line(
                        transaction.getDescription() + ": " + MoneyFormatter.format(transaction.getAmount())));

        ConsolePrinter.title("Despesas (interface funcional própria)");
        reportService.filterWithRule(transaction -> transaction.getType() == TransactionType.EXPENSE)
                .forEach(transaction -> ConsolePrinter.line(transaction.toString()));

        ConsolePrinter.title("Fim do programa - halt");
    }
}
