package com.quocanh.kata.tennisplayer;

public abstract class Player {
    private final char name;
    private int score;

    public Player(char playerName) {
        this.name = playerName;
    }

    public char getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player " + this.getName() + ": " + this.getScore();
    }
}
