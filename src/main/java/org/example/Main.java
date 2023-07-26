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
                    pw.println("Hello. This is Server. Please write your name");
                    String clientName = br.readLine();
                    //System.out.println("Client has entered his name: " + clientName);
                    pw.println("Are you child?");
                    String answer = br.readLine();
                    if (answer.equals("yes")) {
                        pw.println("Welcome to the kids area, " + clientName + "! Let's play!");
                    } else if (answer.equals("no")) {
                        pw.println("Welcome to the adult zone, " + clientName + "! Have a good rest, or a good working day!");
                    } else pw.println("Yes or no I said");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}