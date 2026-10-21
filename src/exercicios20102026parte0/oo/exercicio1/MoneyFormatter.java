package exercicios20102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class MoneyFormatter {
    private static final NumberFormat FORMATTER = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    private MoneyFormatter() {}

    public static String format(BigDecimal amount) {
        return FORMATTER.format(amount);
    }
}
