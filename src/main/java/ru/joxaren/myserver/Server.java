package ru.joxaren.myserver;

import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8300);


        //clientSocket.getOutputStream().write(64);

        int clientCount = 0;

        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("accept clients: " + clientCount++);
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("HTTP/1.0 200 OK\r\n" +
                    "Content-type text/html\r\n"+
                    "\r\n"+
                    "<h1>Hello world!!! " + clientCount + "</h1>\r\n");
            writer.flush();

            writer.close();
            clientSocket.close();
        }

        //serverSocket.close();

    }
}
