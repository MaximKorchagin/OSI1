package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is ready");
            while (true) {
                try (Socket client = serverSocket.accept();
                     PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))
                ) {
                    String s = br.readLine();
                    System.out.println("The info from Client: " + s + "\nClient is running on port: " + client.getPort());
                    pw.println(client.getPort());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}