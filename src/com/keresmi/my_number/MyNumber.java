package com.keresmi.my_number;

public class MyNumber {

    private double number;

    public MyNumber(double number) {
        this.number = number;
    }

    public boolean isOdd() {
        return number % 2 == 1;
    }

    public boolean isEven() {
        return number % 2 == 0;
        // return !isOdd();
    }

    public MyNumber sqrt() {
        double sqrt = Math.sqrt(number);
        return new MyNumber(sqrt);
    }

    public MyNumber pow(MyNumber x) {
        double pow = Math.pow(number, x.number);
        return new MyNumber(pow);
    }

    public MyNumber add(MyNumber x) {
        double sum = number + x.number;
        return new MyNumber(sum);
    }

    public MyNumber subtract(MyNumber x) {
        double subtract = number - x.number;
        return new MyNumber(subtract);
    }
}
