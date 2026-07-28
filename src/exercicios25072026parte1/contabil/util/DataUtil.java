package exercicios25072026parte1.contabil.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DataUtil {

    private static final DateTimeFormatter BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private DataUtil() { }

    public static String formatar(LocalDate data) {
        return data.format(BR);
    }

}