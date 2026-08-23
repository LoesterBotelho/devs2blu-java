package parsecast;

public final class Caster {

    private Caster() {
        throw new UnsupportedOperationException("Utility class");
    }

    // byte

    public static short byteToShort(byte value) {
        return (short) value;
    }

    public static int byteToInt(byte value) {
        return (int) value;
    }

    public static long byteToLong(byte value) {
        return (long) value;
    }

    public static float byteToFloat(byte value) {
        return (float) value;
    }

    public static double byteToDouble(byte value) {
        return (double) value;
    }

    // short

    public static byte shortToByte(short value) {
        return (byte) value;
    }

    public static int shortToInt(short value) {
        return (int) value;
    }

    public static long shortToLong(short value) {
        return (long) value;
    }

    public static float shortToFloat(short value) {
        return (float) value;
    }

    public static double shortToDouble(short value) {
        return (double) value;
    }

    // int

    public static byte intToByte(int value) {
        return (byte) value;
    }

    public static short intToShort(int value) {
        return (short) value;
    }

    public static long intToLong(int value) {
        return (long) value;
    }

    public static float intToFloat(int value) {
        return (float) value;
    }

    public static double intToDouble(int value) {
        return (double) value;
    }

    // long

    public static byte longToByte(long value) {
        return (byte) value;
    }

    public static short longToShort(long value) {
        return (short) value;
    }

    public static int longToInt(long value) {
        return (int) value;
    }

    public static float longToFloat(long value) {
        return (float) value;
    }

    public static double longToDouble(long value) {
        return (double) value;
    }

    // float

    public static byte floatToByte(float value) {
        return (byte) value;
    }

    public static short floatToShort(float value) {
        return (short) value;
    }

    public static int floatToInt(float value) {
        return (int) value;
    }

    public static long floatToLong(float value) {
        return (long) value;
    }

    public static double floatToDouble(float value) {
        return (double) value;
    }

    // double

    public static byte doubleToByte(double value) {
        return (byte) value;
    }

    public static short doubleToShort(double value) {
        return (short) value;
    }

    public static int doubleToInt(double value) {
        return (int) value;
    }

    public static long doubleToLong(double value) {
        return (long) value;
    }

    public static float doubleToFloat(double value) {
        return (float) value;
    }

    // char

    public static int charToInt(char value) {
        return (int) value;
    }

    public static long charToLong(char value) {
        return (long) value;
    }

    public static float charToFloat(char value) {
        return (float) value;
    }

    public static double charToDouble(char value) {
        return (double) value;
    }

    public static short charToShort(char value) {
        return (short) value;
    }

    public static byte charToByte(char value) {
        return (byte) value;
    }

    // boolean

    /*
     * boolean cannot be cast to numeric types.
     * These conversions must be explicit:
     */

    public static int booleanToInt(boolean value) {
        return value ? 1 : 0;
    }

    public static int booleanToInteger(boolean value) {
        return booleanToInt(value);
    }

    // Numeric -> boolean

    public static boolean intToBoolean(int value) {
        return value != 0;
    }

    public static boolean longToBoolean(long value) {
        return value != 0;
    }

    public static boolean doubleToBoolean(double value) {
        return value != 0.0;
    }

    // char <-> String

    public static String charToString(char value) {
        return String.valueOf(value);
    }

    public static char stringToChar(String value) {
        if (value == null || value.length() != 1) {
            throw new IllegalArgumentException(
                    "Value must contain exactly one character"
            );
        }

        return value.charAt(0);
    }

    // Object casting

    public static <T> T cast(Object value, Class<T> targetType) {
        return targetType.cast(value);
    }
}