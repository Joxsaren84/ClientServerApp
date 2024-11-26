package ru.joxaren.myclient;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 8300);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        writer.write("Give me message!");
        writer.newLine();
        writer.flush();

        String s;

        while (true) {
            s = reader.readLine();
            if (s != null)
                System.out.println(s);
            else
                break;
        }

        writer.close();
        reader.close();
        clientSocket.close();

    }
}
