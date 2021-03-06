package ru.sberbank.school.HomeTask16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String name;
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) {
        String serverHost = args.length > 0 ? args[0] : DEFAULT_HOST;
        int serverPort = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_PORT;

        try (Socket serverSocket = new Socket(serverHost, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
             PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), false)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            name = scanner.nextLine();
            out.println(name + " joined SchoolChat");
            do {
                System.out.print("Enter your message: ");
                String value = scanner.nextLine();
                out.println(name + " >> " + value);
                out.flush();
            } while (!"exit".equalsIgnoreCase(in.readLine()));
            out.println(name + " exit");
        } catch (IOException e) {}
    }
}
