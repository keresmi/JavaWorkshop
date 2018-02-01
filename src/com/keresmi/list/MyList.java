package com.keresmi.list;

import java.util.Arrays;

public class MyList {

    private int[] numbers;
    private int capacity;
    private int size;

    public MyList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        numbers = new int[capacity];
    }

    public void addElement(int number) {
        numbers[size] = number;
        size++;
    }

    public int findIndex(int number) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println(toString());
    }

    public void removeFirst(int number) {
        int[] result = new int[capacity];
        int index = 0;
        boolean firstFound = false;
        for (int i = 0; i < size; i++) {
            if (numbers[i] != number || firstFound) {
               result[index] = numbers[i];
               index++;
            } else {
                firstFound = true;
            }
        }
        numbers = result;
    }

    public void removeRepetition(int number) {
        int[] result = new int[capacity];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i] != number) {
                result[index] = numbers[i];
                index++;
            }
        }
        numbers = result;
    }

    public void reverse() {
        int[] result = new int[capacity];
        int index = 0;
        for (int i = size -1; i >= 0; i--) {
            result[index] = numbers[i];
            index++;
        }
        numbers = result;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "numbers=" + Arrays.toString(numbers) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
