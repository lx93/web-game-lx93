package com.example.appengine.java8;

public class GameInstance implements Comparable<GameInstance>{

    private String player;
    private int score = 0;

    public GameInstance(String player) { this.player = player; }

    public String getPlayer() { return player; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public int compareTo(GameInstance instance) { return (this.score-instance.score); }

    @Override
    public String toString() { return "player: " + player + ", score: " + score + "\n"; }
}
