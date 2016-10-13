package ru.sberbank.school.HomeTask8;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String dir = "F:\\tmp";
        try {
            File file = new PluginManager(dir).findFile("2.txt", new File(dir));
            if (file == null) {
                System.out.println("null");
            } else {
                System.out.println(file.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
