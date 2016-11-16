package ru.sberbank.school.HomeTask16b.main;

import ru.sberbank.school.HomeTask16b.client.Client;
import ru.sberbank.school.HomeTask16b.server.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"s\" for server and \"c\" for client");
        while (true) {
            char answer = Character.toLowerCase(sc.nextLine().charAt(0));
            if (answer == 's') {
                new Server();
                break;
            } else if (answer == 'c') {
                new Client();
                break;
            } else {
                System.out.println("Wrong command, try again.");
            }
        }
    }
}
