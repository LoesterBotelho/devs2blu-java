package exercicios25072026parte1.contabil.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class MoedaUtil {

	private static final NumberFormat FORMATADOR = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    private MoedaUtil() { }

    public static String formatar(BigDecimal valor) {
        return FORMATADOR.format(valor);
    }
}