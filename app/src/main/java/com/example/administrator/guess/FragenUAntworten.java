package com.example.administrator.guess;

public class FragenUAntworten {
    private int id;
    private String fragen;
    private String antworten;
    private String kapitel;

    public void setId(int id) {
        this.id = id;
    }

    public void setFragen(String fragen) {
        this.fragen = fragen;
    }

    public void setAntworten(String antworten) {
        this.antworten = antworten;
    }

    public void setKapitel(String kapitel) {
        this.kapitel = kapitel;
    }

    public int getId() {
        return id;
    }

    public String getFragen() {
        return fragen;
    }

    public String getAntworten() {
        return antworten;
    }

    public String getKapitel() {
        return kapitel;
    }

}