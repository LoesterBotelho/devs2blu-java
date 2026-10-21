package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class FinancialTransaction {
    private final long id;
    private final long accountId;
    private final TransactionType type;
    private final Category category;
    private final BigDecimal amount;
    private final String description;
    private final LocalDate date;

    public FinancialTransaction(long id, long accountId, TransactionType type,
            Category category, BigDecimal amount, String description, LocalDate date) {
        if (id <= 0 || accountId <= 0) throw new IllegalArgumentException("IDs must be positive.");
        this.id = id;
        this.accountId = accountId;
        this.type = Objects.requireNonNull(type);
        this.category = Objects.requireNonNull(category);
        this.amount = Objects.requireNonNull(amount);
        if (amount.signum() <= 0) throw new IllegalArgumentException("Amount must be positive.");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Description is required.");
        this.description = description;
        this.date = Objects.requireNonNull(date);
    }

    public long getId() { return id; }
    public long getAccountId() { return accountId; }
    public TransactionType getType() { return type; }
    public Category getCategory() { return category; }
    public BigDecimal getAmount() { return amount; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return date + " | " + type + " | " + category + " | " + description + " | " + amount;
    }
}
