package parsecast;

public class CasterMain {

	public static void main(String[] args) {

		System.out.println("BYTE");

		byte byteValue = 10;

		System.out.println("byte -> short: " + Caster.byteToShort(byteValue));

		System.out.println("byte -> int: " + Caster.byteToInt(byteValue));

		System.out.println("byte -> long: " + Caster.byteToLong(byteValue));

		System.out.println("byte -> float: " + Caster.byteToFloat(byteValue));

		System.out.println("byte -> double: " + Caster.byteToDouble(byteValue));

		
		
		
		
		System.out.println("\n\n\nSHORT");

		short shortValue = 100;

		System.out.println("short -> byte: " + Caster.shortToByte(shortValue));

		System.out.println("short -> int: " + Caster.shortToInt(shortValue));

		System.out.println("short -> long: " + Caster.shortToLong(shortValue));

		System.out.println("short -> float: " + Caster.shortToFloat(shortValue));

		System.out.println("short -> double: " + Caster.shortToDouble(shortValue));

		
		
		
		
		System.out.println("\n\n\nINT");

		int intValue = 1000;

		System.out.println("int -> byte: " + Caster.intToByte(intValue));

		System.out.println("int -> short: " + Caster.intToShort(intValue));

		System.out.println("int -> long: " + Caster.intToLong(intValue));

		System.out.println("int -> float: " + Caster.intToFloat(intValue));

		System.out.println("int -> double: " + Caster.intToDouble(intValue));

		
		
		
		
		System.out.println("\n\n\nLONG");

		long longValue = 100000L;

		System.out.println("long -> byte: " + Caster.longToByte(longValue));

		System.out.println("long -> short: " + Caster.longToShort(longValue));

		System.out.println("long -> int: " + Caster.longToInt(longValue));

		System.out.println("long -> float: " + Caster.longToFloat(longValue));

		System.out.println("long -> double: " + Caster.longToDouble(longValue));

		
		
		
		
		System.out.println("\n\n\nFLOAT");

		float floatValue = 100.5f;

		System.out.println("float -> byte: " + Caster.floatToByte(floatValue));

		System.out.println("float -> short: " + Caster.floatToShort(floatValue));

		System.out.println("float -> int: " + Caster.floatToInt(floatValue));

		System.out.println("float -> long: " + Caster.floatToLong(floatValue));

		System.out.println("float -> double: " + Caster.floatToDouble(floatValue));

		
		
		
		
		System.out.println("\n\n\nDOUBLE");

		double doubleValue = 100.99;

		System.out.println("double -> byte: " + Caster.doubleToByte(doubleValue));

		System.out.println("double -> short: " + Caster.doubleToShort(doubleValue));

		System.out.println("double -> int: " + Caster.doubleToInt(doubleValue));

		System.out.println("double -> long: " + Caster.doubleToLong(doubleValue));

		System.out.println("double -> float: " + Caster.doubleToFloat(doubleValue));

		
		
		
		
		System.out.println("\n\n\nCHAR");

		char charValue = 'A';

		System.out.println("char -> byte: " + Caster.charToByte(charValue));

		System.out.println("char -> short: " + Caster.charToShort(charValue));

		System.out.println("char -> int: " + Caster.charToInt(charValue));

		System.out.println("char -> long: " + Caster.charToLong(charValue));

		System.out.println("char -> float: " + Caster.charToFloat(charValue));

		System.out.println("char -> double: " + Caster.charToDouble(charValue));

		System.out.println("char -> String: " + Caster.charToString(charValue));

		
		
		
		
		System.out.println("\n\n\nBOOLEAN");

		boolean booleanValue = true;

		System.out.println("boolean -> int: " + Caster.booleanToInt(booleanValue));

		
				
		System.out.println("\n\n\nNUMERIC -> BOOLEAN");

		System.out.println("int -> boolean: " + Caster.intToBoolean(1));

		System.out.println("long -> boolean: " + Caster.longToBoolean(0));

		System.out.println("double -> boolean: " + Caster.doubleToBoolean(10.5));

		
		
		
		
		System.out.println("\n\n\nSTRING <-> CHAR");

		System.out.println("char -> String: " + Caster.charToString('X'));

		System.out.println("String -> char: " + Caster.stringToChar("Y"));

		
		
		
		System.out.println("\n\n\nOBJECT CAST");

		Object value = "Hello Java 25";

		String text = Caster.cast(value, String.class);

		System.out.println("Object -> String: " + text);

	}
}