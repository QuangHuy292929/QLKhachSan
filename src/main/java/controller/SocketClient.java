package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.35.111", 8000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Luồng đọc dữ liệu từ Server
            Thread readThread = new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received from server: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readThread.start();

            // Luồng ghi dữ liệu đến Server
            Thread writeThread = new Thread(() -> {
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String message;
                try {
                    while ((message = userInput.readLine()) != null) {
                        out.println(message);
                        System.out.println("Client: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writeThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}