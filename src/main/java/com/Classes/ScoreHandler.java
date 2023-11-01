package com.Classes;

public class ScoreHandler {
    private static int storedScore = 0;

    public static void setScore(int score) {
        storedScore = score;
    }

    public static int getScore() {
        return storedScore;
    }

    //TODO write score to CSV
}
