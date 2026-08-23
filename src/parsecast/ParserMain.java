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

public class ParserMain {

	public static void main(String[] args) {

		
		System.out.println("PRIMITIVE TYPES");

		byte byteValue = Parser.toByte("10");
		System.out.println("byte: " + byteValue);

		short shortValue = Parser.toShort("100");
		System.out.println("short: " + shortValue);

		int intValue = Parser.toInt("1000");
		System.out.println("int: " + intValue);

		long longValue = Parser.toLong("100000");
		System.out.println("long: " + longValue);

		float floatValue = Parser.toFloat("10.5");
		System.out.println("float: " + floatValue);

		double doubleValue = Parser.toDouble("99.99");
		System.out.println("double: " + doubleValue);

		boolean booleanValue = Parser.toBoolean("true");
		System.out.println("boolean: " + booleanValue);

		char charValue = Parser.toChar("A");
		System.out.println("char: " + charValue);

		
		
		
		System.out.println("\n\n\nWRAPPER TYPES");

		Byte byteObject = Parser.toByteObject("10");
		System.out.println("Byte: " + byteObject);

		Short shortObject = Parser.toShortObject("100");
		System.out.println("Short: " + shortObject);

		Integer integer = Parser.toInteger("1000");
		System.out.println("Integer: " + integer);

		Long longObject = Parser.toLongObject("100000");
		System.out.println("Long: " + longObject);

		Float floatObject = Parser.toFloatObject("10.5");
		System.out.println("Float: " + floatObject);

		Double doubleObject = Parser.toDoubleObject("99.99");
		System.out.println("Double: " + doubleObject);

		Boolean booleanObject = Parser.toBooleanObject("true");
		System.out.println("Boolean: " + booleanObject);

		Character character = Parser.toCharacter("A");
		System.out.println("Character: " + character);

		
		
		
		System.out.println("\n\n\nBIG NUMBERS");

		BigInteger bigInteger = Parser.toBigInteger("12345678901234567890");

		System.out.println("BigInteger: " + bigInteger);

		BigDecimal bigDecimal = Parser.toBigDecimal("1234567890.123456789");

		System.out.println("BigDecimal: " + bigDecimal);

		
		
		
		
		System.out.println("\n\n\nJAVA TIME");

		LocalDate localDate = Parser.toLocalDate("2026-08-23");

		System.out.println("LocalDate: " + localDate);

		LocalTime localTime = Parser.toLocalTime("18:30:00");

		System.out.println("LocalTime: " + localTime);

		LocalDateTime localDateTime = Parser.toLocalDateTime("2026-08-23T18:30:00");

		System.out.println("LocalDateTime: " + localDateTime);

		OffsetDateTime offsetDateTime = Parser.toOffsetDateTime("2026-08-23T18:30:00-03:00");

		System.out.println("OffsetDateTime: " + offsetDateTime);

		OffsetTime offsetTime = Parser.toOffsetTime("18:30:00-03:00");

		System.out.println("OffsetTime: " + offsetTime);

		ZonedDateTime zonedDateTime = Parser.toZonedDateTime("2026-08-23T18:30:00-03:00[America/Sao_Paulo]");

		System.out.println("ZonedDateTime: " + zonedDateTime);

		Instant instant = Parser.toInstant("2026-08-23T21:30:00Z");

		System.out.println("Instant: " + instant);

		Duration duration = Parser.toDuration("PT2H30M");

		System.out.println("Duration: " + duration);

		Year year = Parser.toYear("2026");

		System.out.println("Year: " + year);

		ZoneId zoneId = Parser.toZoneId("America/Sao_Paulo");

		System.out.println("ZoneId: " + zoneId);

		ZoneOffset zoneOffset = Parser.toZoneOffset("-03:00");

		System.out.println("ZoneOffset: " + zoneOffset);

		
		
		
		
		System.out.println("\n\n\nUUID");

		UUID uuid = Parser.toUUID("550e8400-e29b-41d4-a716-446655440000");

		System.out.println("UUID: " + uuid);

	}
}