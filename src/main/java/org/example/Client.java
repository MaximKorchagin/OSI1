package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
            try (Socket socket = new Socket("netology.homework", Main.PORT);
                 PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(br.readLine());
                pw.println(scanner.nextLine());
                System.out.println(br.readLine());
                pw.println(scanner.nextLine());
                System.out.println(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}
