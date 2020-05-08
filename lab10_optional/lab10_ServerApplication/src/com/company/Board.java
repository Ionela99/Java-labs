package com.company;

public class Board {
    private char[][] tabla;

    public Board() {
        tabla = new char[19][19];
        resetare();
    }

    public boolean mutare(int linie, int col, char c) {
        if(col < 0 || col > 18) {
            return false;
        }
        if(linie < 0 || linie > 18) {
            return false;
        }
        tabla[linie][col]=c;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                buffer.append(tabla[i][j]);
                if (j < 18) {
                    buffer.append(' ');
                } else {
                    buffer.append("#");
                }
            }
        }

        return buffer.toString();
    }

    public void resetare() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                tabla[i][j] = '_';
            }
        }
    }
}
