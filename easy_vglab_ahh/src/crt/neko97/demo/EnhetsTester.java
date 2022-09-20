package crt.neko97.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnhetsTester {

    @Test
    void rollTest(){
        var testDice = new Dice(0,1,7);
        testDice.roll();
    }
    @Test
    void getDiceTest(){
        var testDice2 = new Dice(2,0,0);
        System.out.println(testDice2.getDiceNumber());
    }
    @Test
    void setNameTest(){
        var playerName = new Player("Simon");
        System.out.println(playerName.getName());
    }
}