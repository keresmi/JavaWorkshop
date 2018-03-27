package com.keresmi.calculator;

public class Calculator {

    public static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
        // return !isOdd(number);
    }

    public static double sqrt(int number) {
        return Math.sqrt(number);
    }

    public static double pow(int number, int pow) {
        return Math.pow(number, pow);
    }

    public static int add(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    public static int subtract(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }
}
