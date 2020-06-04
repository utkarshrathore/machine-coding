package com.games.snakeladder.utils;

import java.util.Random;

public class DiceRoller {
    private Random rand;

    public DiceRoller() {
        rand = new Random();
    }

    public int roll() {
        return rand.nextInt(5)+1;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }
}