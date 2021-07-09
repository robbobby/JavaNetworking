package com.mir2.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    private final ServerSocket serverSocket;
    private final Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;
    BufferedReader buffer;

    public Connection(int portNumber) throws IOException {
            serverSocket = new ServerSocket(portNumber);
            socket = serverSocket.accept();

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            buffer = new BufferedReader(new InputStreamReader(System.in));
    }

    public void runConnection() throws IOException {
        int command = 0;
        int response = 0;

        while (command != 1 ) {
            command = inputStream.readInt();
            System.out.println("Clients message: " + command);
            response = buffer.read();
            outputStream.writeInt(response);
            outputStream.flush();
        }
    }

    public void closeConnection() throws IOException {
        inputStream.close();
        outputStream.close();
        serverSocket.close();
    }
}
