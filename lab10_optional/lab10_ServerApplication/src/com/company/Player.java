package com.company;

import java.net.Socket;

public class Player {
    private int playerId;
    private int gameId;
    ClientThread clientThread;

    public Player(GameServer server, Socket socket) {
        clientThread = new ClientThread(server, socket, this);
        gameId = -1;
        playerId = -1;
    }

    public void start() {
        clientThread.start();
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}