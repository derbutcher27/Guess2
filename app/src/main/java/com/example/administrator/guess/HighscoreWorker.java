package com.example.administrator.guess;

public class HighscoreWorker {

    //private variables
    private int id;

    private String score;

    // Empty constructor
    public HighscoreWorker() {
    }

    // constructor
    public HighscoreWorker(String score) {
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

    // getting score
    public String getScore() {
        return this.score;
    }

    // setting score
    public void setScore(String score) {
        this.score = score;
    }
}