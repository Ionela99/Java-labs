package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer {
    public static final int PORT = 8100;
    ServerSocket serverSocket = null;
    ArrayList<Player> players;
    ArrayList<Game> games;
    private int totalPlayers = 0;
    private int totalGames = 0;

    public GameServer() throws IOException {
        players = new ArrayList<Player>();
        games = new ArrayList<Game>();
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                Player newPlayer = new Player(this, socket);
                totalPlayers++;
                newPlayer.setPlayerId(totalPlayers);
                players.add(newPlayer);
                // Execute the client's request in a new thread
                newPlayer.start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }

    public void removePlayer(Player player) throws IOException {
        if(player.getGameId() > -1) {
            for(Game game: games) {
                if (game.getGameId() == player.getGameId()) {
                    game.exit(player);
                    if(game.totalPlayers() == 0) {
                        games.remove(game);
                    }
                    break;
                }
            }
        }

        players.remove(player);
    }

    public String getGames() {
        StringBuilder buffer = new StringBuilder();

        for(Game game: games) {
            buffer.append("Game ").append(game.getGameId());
            buffer.append(" | Total players: ").append(game.totalPlayers());
        }

        return buffer.toString();
    }

    public String joinGame(Player player, int gameId){
        for(Game game: games) {
            if(game.getGameId() == gameId) {
                if(game.join(player)) {
                    return "You joined the game with id = " + gameId + "#";
                }

                break;
            }
        }
        return "The Id " + gameId + "doesn't exist #";
    }

    public String displayGame(int gameId) {
        if(gameId == -1) {
            return "You are not in a game.#";
        }

        for(Game game: games) {
            if(game.getGameId() == gameId) {
                return game.displayBoard();
            }
        }
        return "Try again #";
    }

    public String mutare(Player player, int linie, int col){
        if(player.getGameId() < 0) {
            return "You are not in a game.#";
        }

        for(Game game: games) {
            if(game.playerExists(player) != 0) {
                if(game.totalPlayers() < 2) {
                    return "Two players are required #";
                }
                if(!game.mutare(player, linie, col)) {
                    return "It's not your turn #";
                }
            }
        }
        return "Waiting for the other player to make a move #";
    }
}

