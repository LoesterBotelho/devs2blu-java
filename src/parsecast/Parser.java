package parsecast;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class Parser {

    private Parser() {
        throw new UnsupportedOperationException("Utility class");
    }

    // Primitive / Wrapper Types

    public static byte toByte(String value) {
        return Byte.parseByte(value);
    }

    public static Byte toByteObject(String value) {
        return Byte.valueOf(value);
    }

    public static short toShort(String value) {
        return Short.parseShort(value);
    }

    public static Short toShortObject(String value) {
        return Short.valueOf(value);
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static Integer toInteger(String value) {
        return Integer.valueOf(value);
    }

    public static long toLong(String value) {
        return Long.parseLong(value);
    }

    public static Long toLongObject(String value) {
        return Long.valueOf(value);
    }

    public static float toFloat(String value) {
        return Float.parseFloat(value);
    }

    public static Float toFloatObject(String value) {
        return Float.valueOf(value);
    }

    public static double toDouble(String value) {
        return Double.parseDouble(value);
    }

    public static Double toDoubleObject(String value) {
        return Double.valueOf(value);
    }

    public static boolean toBoolean(String value) {
        return Boolean.parseBoolean(value);
    }

    public static Boolean toBooleanObject(String value) {
        return Boolean.valueOf(value);
    }

    public static char toChar(String value) {
        if (value == null || value.length() != 1) {
            throw new IllegalArgumentException(
                    "Value must contain exactly one character"
            );
        }

        return value.charAt(0);
    }

    public static Character toCharacter(String value) {
        return toChar(value);
    }

    // Big Numbers

    public static BigInteger toBigInteger(String value) {
        return new BigInteger(value);
    }

    public static BigDecimal toBigDecimal(String value) {
        return new BigDecimal(value);
    }

    // Java Time API

    public static LocalDate toLocalDate(String value) {
        return LocalDate.parse(value);
    }

    public static LocalTime toLocalTime(String value) {
        return LocalTime.parse(value);
    }

    public static LocalDateTime toLocalDateTime(String value) {
        return LocalDateTime.parse(value);
    }

    public static OffsetDateTime toOffsetDateTime(String value) {
        return OffsetDateTime.parse(value);
    }

    public static OffsetTime toOffsetTime(String value) {
        return OffsetTime.parse(value);
    }

    public static ZonedDateTime toZonedDateTime(String value) {
        return ZonedDateTime.parse(value);
    }

    public static Instant toInstant(String value) {
        return Instant.parse(value);
    }

    public static Duration toDuration(String value) {
        return Duration.parse(value);
    }

    public static Year toYear(String value) {
        return Year.parse(value);
    }

    public static ZoneId toZoneId(String value) {
        return ZoneId.of(value);
    }

    public static ZoneOffset toZoneOffset(String value) {
        return ZoneOffset.of(value);
    }

    // UUID

    public static UUID toUUID(String value) {
        return UUID.fromString(value);
    }

    // String

    public static String toStringValue(String value) {
        return value;
    }
}