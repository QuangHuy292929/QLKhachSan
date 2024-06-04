package View;

import java.io.BufferedReader;   
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import RSA.Mahoaclient;

public class Client {
    private static String serverAddress = "localhost";
    private static int serverPort = 8000;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static Mahoaclient mhclient;

    public Client() {
        try {
            socket = new Socket(serverAddress, serverPort);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Kết nối không thành công");
        }
    }

    public void sendMessage(String message) throws Exception {
    	try {
			String mahoa = mhclient.maHoaDuLieu(message);
			out.println(mahoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public String receiveMessage() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public void closeConnection() {
        try {
            in.close();
            out.close();
            socket.close();
            System.out.println("Đã ngắt kết nối tới server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
