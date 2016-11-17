package ru.sberbank.school.HomeTask16c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String IP = "localhost";
    private static final int PORT = 1234;

    private static BufferedReader in;
    private static PrintWriter out;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket(IP, PORT);
            Scanner sc = new Scanner(System.in);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter your name: ");
            out.println(sc.nextLine());

            Resender resender = new Client().new Resender();
            new Thread(resender).start();

            String message;
            while (true) {
                message = sc.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                out.println(message);
            }
            resender.setStop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private static void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Resender implements Runnable {
        private boolean isStopped;

        public void setStop() {
            isStopped = true;
        }

        @Override
        public void run() {
            try {
                while (!isStopped) {
                    System.out.println(in.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
