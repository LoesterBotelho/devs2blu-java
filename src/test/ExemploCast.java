package test;

public class ExemploCast {

    public static void main(String[] args) {

        System.out.println("TIPOS ORIGINAIS");

        byte b = 10;
        short s = 20;
        int i = 30;
        long l = 40L;
        float f = 50.5f;
        double d = 60.99;
        char c = 'A';

        System.out.println("byte   = " + b);
        System.out.println("short  = " + s);
        System.out.println("int    = " + i);
        System.out.println("long   = " + l);
        System.out.println("float  = " + f);
        System.out.println("double = " + d);
        System.out.println("char   = " + c);

        /*
         * CAST IMPLÍCITO (WIDENING)
         * Vai de um tipo menor para um maior.
         * Não perde informação.
         */

        System.out.println("\nCAST IMPLÍCITO");

        short shortDeByte = b;
        int intDeShort = s;
        long longDeInt = i;
        float floatDeLong = l;
        double doubleDeFloat = f;

        System.out.println(shortDeByte);
        System.out.println(intDeShort);
        System.out.println(longDeInt);
        System.out.println(floatDeLong);
        System.out.println(doubleDeFloat);

        /*
         * CAST EXPLÍCITO (NARROWING)
         * Vai de um tipo maior para um menor.
         * Pode perder informação.
         */

        System.out.println("\nCAST EXPLÍCITO");

        byte byteDeInt = (byte) i;
        short shortDeInt = (short) i;
        int intDeLong = (int) l;
        long longDeDouble = (long) d;
        float floatDeDouble = (float) d;

        System.out.println(byteDeInt);
        System.out.println(shortDeInt);
        System.out.println(intDeLong);
        System.out.println(longDeDouble);
        System.out.println(floatDeDouble);

        /*
         * CHAR
         * Armazena códigos Unicode.
         */

        System.out.println("\nCHAR");

        int codigoAscii = c;

        System.out.println("Char: " + c);
        System.out.println("Código: " + codigoAscii);

        char letra = (char) 66;

        System.out.println("66 => " + letra);

        /*
         * DOUBLE PARA OUTROS TIPOS
         */

        System.out.println("\nDOUBLE PARA OUTROS");

        System.out.println((byte) d);
        System.out.println((short) d);
        System.out.println((int) d);
        System.out.println((long) d);
        System.out.println((float) d);

        /*
         * INT PARA OUTROS TIPOS
         */

        System.out.println("\nINT PARA OUTROS");

        System.out.println((byte) i);
        System.out.println((short) i);
        System.out.println((long) i);
        System.out.println((float) i);
        System.out.println((double) i);

    }
}