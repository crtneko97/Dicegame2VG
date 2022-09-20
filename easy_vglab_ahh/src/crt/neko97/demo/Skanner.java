package crt.neko97.demo;

import crt.neko97.demo.Dice;
import crt.neko97.demo.Game;
import crt.neko97.demo.Player;

import java.util.Scanner;

public class Skanner {
    Scanner scanner = new Scanner(System.in);
    public String scanString(){
        return scanner.next();
    }
    public int scanInt(){
        return scanner.nextInt();
    }

}
