package crt.neko97.demo;

import java.util.Random;

public class Dice {
    Random random = new Random();
    Skanner skanner = new Skanner();
    Dice dice;
    public int diceNumber;
    public int minNumber;
    public int maxNumber;


    public Dice(int diceNumber, int minNumber, int maxNumber){
        this.diceNumber = diceNumber;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber + 1;
    }
    public void howManyDice(){
        System.out.print("How many dices would u like to use: ");
        diceNumber = skanner.scanInt();
    }
    public void setDiceNumber(int diceNumber){
        this.diceNumber = diceNumber;
    }
    public int getDiceNumber(){
        return diceNumber;
    }
    public int roll(){
        return random.nextInt(1, 7);
    }
}
