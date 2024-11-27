package ru.joxaren.guessthenumber.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 5252);
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String massage;
        System.out.println(reader.readLine());

        do {
            writer.write(scanner.next());
            writer.newLine();
            writer.flush();

            massage = reader.readLine();
            System.out.println(massage);

        } while (!massage.equals("Oh, you know it!"));

        scanner.close();
        writer.close();
        reader.close();
        clientSocket.close();
    }
}
