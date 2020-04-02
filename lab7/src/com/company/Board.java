package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Token> tokens;
    public Board(int n, int m, int k) {
        Integer[] v = new Integer[m];
        for(int i = 1; i <= m; i++) {
            v[i - 1] = i;
        }

        tokens = new ArrayList<Token>();
        Random random = new Random();
    }
}
