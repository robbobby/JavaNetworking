package com.mir2.server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Connection connection = new Connection(6666);
        connection.runConnection();
        connection.closeConnection();
    }
}
