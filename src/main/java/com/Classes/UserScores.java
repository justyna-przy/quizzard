package com.Classes;

import java.util.List;

public class UserScores {

    private String username;
    private List<Double> userScores;
    private double userTotal;

    public UserScores(String username,  List<Double> userScores, double userTotal) {
        this.username = username;
        this.userScores = userScores;
        this.userTotal = userTotal;
    }

    public String getUsername(){
        return username;
    }

    public List<Double> getUserScores(){
        return userScores;
    }

    public double getUserTotal() {
        return userTotal;
    }
}