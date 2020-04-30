package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String answer = command(request);
                System.out.println(answer);
                out.println(answer);
                out.flush();

                if (answer.equals("quit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private String command(String request) {
        System.out.println("Server received the request " + request);
        return "Ok";
    }
}