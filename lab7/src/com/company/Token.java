package com.company;

public class Token implements Comparable<Token>{
    private int value;

    public Token(int valoare) {
        value = valoare;
    }

    public int getValue() {
        return value;
    }

    public boolean isBlank() {
        return value==-1;
    }

    @Override
    public int compareTo(Token t) {
        return getValue() - t.getValue();
    }
}