package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Integer.parseInt;

class ClientThread extends Thread {
    private Socket socket = null ;
    private GameServer server = null;
    private Player parent = null;
    private int join;
    private int move;
    private int linie;
    private int col;

    public ClientThread (GameServer server, Socket socket, Player parent) {
        this.socket = socket ;
        this.server = server;
        this.parent = parent;
        join = 0;
        move = 0;
        linie = col = 0;
    }

    public void run () {
        try {
            // Get the request from the input stream: client → server
            while(true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                String answer  = decodeReq(request);

                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(answer);
                out.flush();

                if(answer.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    public String decodeReq(String request) throws IOException {
        System.out.println("Server received the request " + request);

        if(isInteger(request)) {
            if(join == 1) {
                return ExecuteJoinCommand(parseInt(request));
            }

            if(move > 0) {
                return ExecuteMoveCommand(parseInt(request));
            }
        }
        join = 0;
        move = 0;
        if(request.equals("stop")) {
            return ExecuteStopCommand();
        }

        if(request.equals("show")) {
            return ExecuteShowCommand();
        }

        if(request.equals("join")) {
            return ExecuteJoinCommand(-1);
        }

        if(request.equals("display")) {
            return ExecuteDisplayCommand();
        }

        if(request.equals("move")) {
            return ExecuteMoveCommand(-1);
        }

        return "Unknown command " + request + "!";
    }

    public String ExecuteStopCommand() throws IOException {
        server.removePlayer(parent);
        System.out.println("Thread stopped");
        return "exit";
    }

    public String ExecuteShowCommand() {
        return server.getGames();
    }

    public String ExecuteJoinCommand(int gameId) throws IOException {
        if(join == 0) {
            join = 1;
            return "Please enter the game id to join: ";
        }
        join = 0;
        return server.joinGame(parent, gameId);
    }

    public String ExecuteDisplayCommand() {
        return server.displayGame(parent.getGameId());
    }

    public String ExecuteMoveCommand(int number) throws IOException {
        if(move == 0) {
            move = 1;
            return "linia: ";
        }

        if(move == 1) {
            linie = number;
            move = 2;
            return "Coloana: ";
        }

        col = number;
        move = 0;
        return server.mutare(parent, linie, col);
    }
}
