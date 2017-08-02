package com.example.administrator.guess;


public class Erfahrungsstufen {

        //private variables
        int id;
        String xp;
        String ranking;

        // Empty constructor
        public Erfahrungsstufen(){
        }
        // constructor
        public Erfahrungsstufen(String xp, String ranking){
            this.xp = xp;
            this.ranking = ranking;
        }
        // getting ID
        public int getID(){
            return this.id;
        }

        // setting ID
        public void setID(int id){
            this.id = id;
        }

        // getting xp
        public String getXp(){
            return this.xp;
        }

        // setting xp
        public void setXp(String xp){
            this.xp = xp;
        }

        // getting ranking
        public String getRanking(){
            return this.ranking;
        }

        // setting ranking
        public void setRanking(String ranking){
            this.ranking = ranking;
        }


}
