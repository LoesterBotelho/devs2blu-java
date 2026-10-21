package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.Objects;

public class FinancialAccount {
    private final long id;
    private final String name;
    private BigDecimal balance;

    public FinancialAccount(long id, String name, BigDecimal openingBalance) {
        if (id <= 0) throw new IllegalArgumentException("Account ID must be positive.");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Account name is required.");
        this.id = id;
        this.name = name;
        this.balance = Objects.requireNonNull(openingBalance, "Opening balance is required.");
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getBalance() { return balance; }

    public void credit(BigDecimal amount) {
        requirePositive(amount);
        balance = balance.add(amount);
    }

    public void debit(BigDecimal amount) {
        requirePositive(amount);
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds in account: " + name);
        }
        balance = balance.subtract(amount);
    }

    private void requirePositive(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount is required.");
        if (amount.signum() <= 0) throw new IllegalArgumentException("Amount must be positive.");
    }

    @Override
    public String toString() {
        return "FinancialAccount{id=" + id + ", name='" + name + "', balance=" + balance + "}";
    }
}
