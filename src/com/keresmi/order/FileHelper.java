package com.keresmi.order;

import java.io.*;

public class FileHelper {


    public static void saveOrder(Order order, String path) {
        try {
            FileOutputStream fileStream = new FileOutputStream(new File(path));
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            objectStream.writeObject(order);

            objectStream.close();
            fileStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Order loadOrder(String path) {
        Order order = null;
        try {
            FileInputStream fileStream = new FileInputStream(new File(path));
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            order = (Order) objectStream.readObject();

            objectStream.close();
            fileStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return order;
    }
}
