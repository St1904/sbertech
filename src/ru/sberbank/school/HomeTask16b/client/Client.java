package ru.sberbank.school.HomeTask16b.client;

import ru.sberbank.school.HomeTask16b.main.Const;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public Client() {
        try {
            socket = new Socket(Const.ip, Const.port);
            Scanner sc = new Scanner(System.in);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter your name: ");
            out.println(sc.nextLine());

            Resender resender = new Resender();
            resender.start();

            String message = "";
//            System.out.print("Enter your message: ");
            while (true) {
                message = sc.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                out.println(message);
//                System.out.print("Enter your message: ");
            }
            resender.setStop();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Resender extends Thread {
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
