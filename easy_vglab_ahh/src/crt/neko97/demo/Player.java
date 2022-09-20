package crt.neko97.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

 public class Player {

    /*TODO
     * Arraylist for Players
     * Arraylist for Score
     * */
    Skanner skanner = new Skanner();
    Random random = new Random();

    public String name;
    public int score;

    public int ranking = 0;

    Player(String name){
        this.name = name;
    }
     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }


     public void setScore(int rollScore){
        this.score += rollScore;
     }
     public int getScore(){
        return score;
     }
 }
