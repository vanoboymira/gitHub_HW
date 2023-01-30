package tests;

public class Java_HW1 {
    public static void main(String[] args) {


        // примитивные переменные

        byte varByte = 127; //-128 ....... 127
        short varShort = 32767; // -32788 ....... 32767
        int varInt = 99999; // -2 в 31 степени ..... 2 в 31 степени -1 must have
        long varLong = 999999L; // -2 в 64 степени ...... до 2 в 64 степени -1

        // Floating point data

        float varFloat = 0.1f; //32bytes
        double varDouble = 1.99d; //64 bytes must have

        //операции с переменными

        System.out.println(varByte + varShort);
        System.out.println(varInt - varLong);
        System.out.println(varByte / varFloat);
        System.out.println(varByte % varShort);
        System.out.println(varByte > varShort);
        System.out.println(varByte == varShort);
        System.out.println(varByte * varShort);



        // переполнение

        System.out.println((byte) (varByte + 100));
        System.out.println((short) (varShort + varLong));

        //вычисления с int и double

        System.out.print("Usual price for this goods is ");
        System.out.print(varInt * varDouble);
        System.out.print(" USD, ");
        System.out.print("but your special price for this goods is ");
        System.out.print(varInt - varDouble);
        System.out.print(" USD");


    }

}


