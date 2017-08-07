package com.example.administrator.guess;

public class HighscoreWorker {

    //private variables
    private int id;
    private String date;
    private Integer score;

    // Empty constructor
    public HighscoreWorker() {
    }

    // constructor
    public HighscoreWorker(String date, Integer score) {
        this.date = date;
        this.score = score;
    }

    // getting ID
    public int getID() {
        return this.id;
    }

    // setting ID
    public void setID(int id) {
        this.id = id;
    }

    // getting username
    public String getDate() {
        return this.date;
    }

    // setting username
    public void setDate(String username) {
        this.date = username;
    }

    // getting score
    public Integer getScore() {
        return this.score;
    }

    // setting score
    public void setScore(Integer score) {
        this.score = score;
    }
}