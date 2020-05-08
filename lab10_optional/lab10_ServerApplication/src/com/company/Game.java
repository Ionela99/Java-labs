package com.company;

public class Game {
    private Board tabla;
    private int gameId;
    private Player player1;
    private Player player2;
    private int rand;

    public Game(Player player) {
        player1 = player;
        player2 = null;
        rand = 1;
        tabla = new Board();
    }

    public int getGameId() {
        return gameId;
    }

    public boolean join(Player player) {
        if(gameId < 0)
            return false;

        if(player2 == null) {
            player2 = player;
            player.setGameId(gameId);
            return true;
        }
        return false;
    }

    public int getTurn() {
        return rand;
    }

    public int totalPlayers() {
        if(player1 == null) {
            return 0;
        }
        if(player2 == null) {
            return 1;
        }
        return 2;
    }

    public int playerExists(Player player) {
        if(player == player1)
            return 1;
        if(player == player2)
            return 2;

        return 0;
    }

    public boolean exit(Player player) {
        if(playerExists(player) > 0) {
            if(player1 == player) {
                player1 = player2;
            }
            player2 = null;
            tabla.resetare();
            return true;
        }

        return false;
    }

    public boolean mutare(Player player, int linie, int col) {
        int order = playerExists(player);

        if(order == getTurn()) {
            if (order > 0) {
                if (order == 1)
                    return tabla.mutare(linie, col, 'B'); //black
                if (order == 2)
                    return tabla.mutare(linie, col, 'W'); //white
            }
        }
        return false;
    }

    public String displayBoard() {
        return tabla.toString();
    }

}