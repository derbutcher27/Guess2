package com.example.administrator.guess;

public class FragenUAntworten {

    //private variables
    int id;
    String frage;
    String antwort;

    // Empty constructor
    public FragenUAntworten(){

    }
    // constructor
    public FragenUAntworten(String frage, String antwort){
        this.frage = frage;
        this.antwort = antwort;
    }
    // getting ID
    public int getID(){
        return this.id;
    }

    // setting ID
    public void setID(int id){
        this.id = id;
    }

    // getting frage
    public String getFrage(){
        return this.frage;
    }

    // setting frage
    public void setFrage(String frage){
        this.frage = frage;
    }

    // getting antwort
    public String getAntwort(){
        return this.antwort;
    }

    // setting antwort
    public void setAntwort(String anwort){
        this.antwort = anwort;
    }
}