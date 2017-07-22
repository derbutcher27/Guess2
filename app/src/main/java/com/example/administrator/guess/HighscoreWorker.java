package com.example.administrator.guess;

public class HighscoreWorker {

    //private variables
    private int id;
    private String username;
    private String score;

    // Empty constructor
    public HighscoreWorker() {
    }

    // constructor
    public HighscoreWorker(String username, String score) {
        this.username = username;
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
    public String getUsername() {
        return this.username;
    }

    // setting username
    public void setUsername(String username) {
        this.username = username;
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