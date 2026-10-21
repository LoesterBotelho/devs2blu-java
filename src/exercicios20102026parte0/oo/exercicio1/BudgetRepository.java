package exercicios20102026parte0.oo.exercicio1;

public class BudgetRepository extends InMemoryRepository<Budget> {
    public BudgetRepository() {
        super(Budget::getId);
    }
}
