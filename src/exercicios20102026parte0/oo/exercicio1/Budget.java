package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.Objects;

public class Budget {
    private final long id;
    private final Category category;
    private final BigDecimal limit;

    public Budget(long id, Category category, BigDecimal limit) {
        if (id <= 0) throw new IllegalArgumentException("Budget ID must be positive.");
        this.id = id;
        this.category = Objects.requireNonNull(category);
        this.limit = Objects.requireNonNull(limit);
        if (limit.signum() <= 0) throw new IllegalArgumentException("Budget limit must be positive.");
    }

    public long getId() { return id; }
    public Category getCategory() { return category; }
    public BigDecimal getLimit() { return limit; }
}
