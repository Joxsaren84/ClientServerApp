package ru.joxaren.guessthenumber.server;

import java.io.*;
import java.net.*;


public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(5252);
        int myNumber = 1984;
        int answer;

        while (true){

            Socket clientSocket = socket.accept();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            writer.write("Guess my number for 1 to 9999");
            writer.newLine();
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
                String line = reader.readLine();
                try {
                    answer = Integer.parseInt(line);
                    if (answer > myNumber) {
                        writer.write("You number is greater");
                        writer.newLine();
                    } else if (answer < myNumber) {
                        writer.write("Your number is less");
                        writer.newLine();
                    } else {
                        writer.write("Oh, you know it!");
                        writer.newLine();
                        break;
                    }
                } catch (Exception e) {
                    writer.write("This is not number");
                    writer.newLine();
                }
                writer.flush();
            }
            writer.close();
            clientSocket.close();
        }
    }
}
