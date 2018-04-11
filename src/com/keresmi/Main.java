package com.keresmi;

import com.keresmi.order.FileHelper;
import com.keresmi.order.Item;
import com.keresmi.order.Order;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    private static void orderPackageTest() {
        Item item1 = new Item("Pepsi", 10, 4.5);
        System.out.println(item1);
        Item item2 = new Item("Lays", 15, 3.5);
        System.out.println(item2);
        Item item3 = new Item("KitKat", 5, 1.5);
        System.out.println(item3);

        Order order = new Order(3);
        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);
        order.removeItem(0);
        System.out.println(order);
        order.addItem(item1);
        double value = order.calculateValue();
        System.out.println(order);
        System.out.println("Value of order: " + value);

        FileHelper.saveOrder(order, "order.ser");
        Order orderFromFile = FileHelper.loadOrder("order.ser");
        System.out.println(orderFromFile);
    }
}
