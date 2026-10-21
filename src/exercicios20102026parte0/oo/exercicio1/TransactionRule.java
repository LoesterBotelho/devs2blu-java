package exercicios20102026parte0.oo.exercicio1;

@FunctionalInterface
public interface TransactionRule {
    boolean test(FinancialTransaction transaction);
}
