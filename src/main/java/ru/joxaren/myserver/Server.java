package ru.joxaren.myserver;

import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8300);
        System.out.println("Server was started!");


        //clientSocket.getOutputStream().write(64);

        int clientCount = 1;

        while(true) {
            Socket clientSocket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Client's message: " + message);


            System.out.println("accept clients: " + clientCount);
            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(clientSocket.getOutputStream()));
            writer.write("Hello!\nYou are " + (clientCount++) + " client!");
            writer.newLine();
            writer.flush();
            writer.close();
            clientSocket.close();
        }

        //serverSocket.close();

    }
}
