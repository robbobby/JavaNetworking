package com.mir2.client;

import java.io.*;
import java.net.Socket;

public class Connection {
    private final Socket socket;
    private final DataOutputStream outputStream;
    private final DataInputStream inputStream;
    BufferedReader buffer;

    public Connection(String ipAddress, int portNumber) throws IOException {
        socket = new Socket(ipAddress, portNumber);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }

    public void runConnection() throws IOException {
        int command = 0;
        int reply = 0;
        while(command != 1) {
            command = buffer.read();
            outputStream.writeInt(command);
            outputStream.flush();
            reply = inputStream.readInt();
            System.out.println("Message from server: " + reply);
        }
    }

    public void closeConnection() throws IOException {
        outputStream.flush();
        outputStream.close();
        socket.close();
    }
}