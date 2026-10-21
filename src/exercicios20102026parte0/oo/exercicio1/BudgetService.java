package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class BudgetService {
    private final BudgetRepository budgets;

    public BudgetService(BudgetRepository budgets) {
        this.budgets = budgets;
    }

    public Budget create(Category category, BigDecimal limit) {
        return budgets.save(new Budget(IdGenerator.nextId(), category, limit));
    }

    public List<Budget> findAll() {
        return budgets.findAll();
    }
}
