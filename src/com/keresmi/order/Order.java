package com.keresmi.order;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Order implements Serializable {

    private Item[] items;
    private int added;
    private int maxSize;

    public Order() {
        maxSize = 10;
        items = new Item[maxSize];
    }

    public Order(int maxSize) {
        this.maxSize = maxSize;
        items = new Item[maxSize];
    }

    public void addItem(Item item) {
        int index = getItemIndex(item);
        if (items.length <= maxSize) {

            if (index == -1) {
                items[added] = item;
                added++;
            } else {
                Item addedItem = items[index];
                addedItem.setQuantity(addedItem.getQuantity() + item.getQuantity());
            }

        } else {
            System.out.println("Unable to add new item. Order is full.");
        }
    }

    public void removeItem(int index) {
        if (index < added) {
            for (int i = index; i < added - 1; i++) {
                items[i] = items[i + 1];
            }
            items[added - 1] = null; // always null the last element
            added--;
        } else System.out.println("Index unavailable");
    }

    public void editItem(int index) {
        if (index < added) {
            Item item = items[index];

            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("Enter a new name: ");
            String newName = scanner.nextLine();
            System.out.println("Add new quantity: ");
            int newQuantity = scanner.nextInt();
            System.out.println("Set new price: ");
            double newPrice = scanner.nextDouble();

            item.setName(newName);
            item.setQuantity(newQuantity);
            item.setPrice(newPrice);
        } else System.out.println("Index unavailable");
    }

    public double calculateValue() {
        double value = 0;
        for (Item item : items) {
            if (item != null) {
                value += item.calculateValue();
            } else break;
        }
        return value;
    }

    private int getItemIndex(Item item) {
        int index = -1;
        for (int i = 0; i < added; i++) {
            if (items[i].getName().equals(item.getName())) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + Arrays.toString(items) +
                ", added=" + added +
                ", maxSize=" + maxSize +
                '}';
    }
}
