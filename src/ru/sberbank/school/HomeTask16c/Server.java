package ru.sberbank.school.HomeTask16c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
    private static final int PORT = 1234;

    private static ServerSocket server;
    private static List<Connection> connections = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);

            while (true) {
                Socket socket = server.accept();

                Connection connection = new Server().new Connection(socket);
                connections.add(connection);
                new Thread(connection).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Connection implements Runnable {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        private String name = "";

        public Connection(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        @Override
        public void run() {
            try {
                name = in.readLine();

                for (Connection connection : connections) {
                    connection.out.println(name + " has joined chat!");
                }

                String message = "";
                while (!message.equals("exit")) {
                    message = in.readLine();

                    for (Connection connection : connections) {
                        connection.out.println(name + ": " + message);
                    }
                }

                for (Connection connection : connections) {
                    connection.out.println(name + " has left chat =(");
                }
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
    }
}
