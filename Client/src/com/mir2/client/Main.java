package com.mir2.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Connection connection = new Connection("localhost", 6666);
        connection.runConnection();
        connection.closeConnection();
    }
}
