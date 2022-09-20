package crt.neko97.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

                                    //Instanceing all my classes ETC here


    Random random = new Random();
    public ArrayList<Player> playerList = new ArrayList<>();
    Player player = new Player("");
    Game game = new Game(0);
    Dice dice = new Dice(0,1,6);
    Skanner skanner = new Skanner();


                                        //Sätter in alla min methods här
    public void addPlayer(Player player){
        playerList.add(player);
    }

    public Player createPlayer(){
        System.out.println("*CREATE PLAYER*");
        System.out.println(Game.ANSI_GREEN + "Input name: " + Game.ANSI_RESET);
        String name = skanner.scanString();
        System.out.println(Game.ANSI_BLUE + name + " Was created" + Game.ANSI_RESET);
        return new Player(name);
    }
    public void showScoreBoard(){
            int[] rankedPlayerList = new int[playerList.size()];
            for (Player player : playerList) {
                rankedPlayerList[player.ranking - 1] = playerList.indexOf(player);
            }
            for (int i = 0; i < rankedPlayerList.length; i++) {
                Player currentPlayer = playerList.get(rankedPlayerList[i]);
                System.out.println("Rank " + (i + 1) + Game.ANSI_PURPLE + "\n\tPlayer " + (playerList.indexOf(currentPlayer) + 1) + "\n\tName: " + currentPlayer.getName() + Game.ANSI_RESET +
                        Game.ANSI_RED + "\n\tScore: " + currentPlayer.getScore() + Game.ANSI_RESET + "\n");
            }
        }
    public void playDice(){

        for(Player player: playerList){ //Reseting the score in the start of a new game.
            player.score = 0;
        }
        for (int i = 1; i <= game.getRounds(); i++ ){ //Getting rounds from the User
            System.out.println(Game.ANSI_RED+"\nROUND " + i + Game.ANSI_RESET);

            for(Player ingamePlayer : playerList){ //Here i'm for looping from the playerlist that was created and for each round in order
                System.out.println(Game.ANSI_BLUE + ingamePlayer.name + " rolls!" + Game.ANSI_RESET);

                for(int j = 1; j <= dice.getDiceNumber(); j++){ //Here i'm taking the dicenumber from the user and looping throw depending on howmany dices are in play
                    int roll = dice.roll();; //creating a new variable and calling the rollmethod from dice
                    ingamePlayer.setScore(roll); //Setting the score that each player in the list to setScore in the playerclass
                    System.out.println(Game.ANSI_GREEN + ingamePlayer.name + "'s " + j + "Dice rolled " + roll + Game.ANSI_RESET); //The restults from the rolls
                }
            }
        }
        for (int i = 0; i < playerList.size(); i++){ //Adding ranking to each player
            Player currentPlayer = playerList.get(i); //
            currentPlayer.ranking = 1;
            for(int j = 0; j < playerList.size(); j++){
                Player nextPlayer = playerList.get(j);
                if(currentPlayer.getScore() < nextPlayer.getScore()){
                    currentPlayer.ranking ++;
                }
            }
        }
        ArrayList<Player> winners = new ArrayList<Player>();
        for (int i = 0; i < playerList.size(); i++){
            Player currentPlayer = playerList.get(i);
            if(currentPlayer.ranking == 1){
                winners.add(currentPlayer);
            }
        }
        if(winners.size() == 1){
            System.out.println(winners.get(0).getName() + " WON!");
        }else {
            System.out.println("Tied!");
            for (Player player : winners) {
                System.out.println(player.getName());
            }
        }
    }

    //MAIN
    public static void main(String[] args) {

        Main main = new Main();
        int option;                         //Option for the switch satement
        do{
            main.game.startMenu();          //Start menu
            option = main.skanner.scanInt();    //My own scannerclass that takes input from user. Scanning the option user wants to choose in the switch

            switch (option){                    //Switch(option) here the switch loop know what case user want's to get use of
                case 1:
                    Player player = main.createPlayer();            //User gets to make a playerprofile
                    main.addPlayer(player);                         //Player profile gets added to the playerList
                    break;

                case 2:
                    main.game.roundNumber();                        //Here the user inputs rounds
                    main.dice.howManyDice();
                    main.playDice();
                    break;

                case 3:
                    main.showScoreBoard();                          //Here is the overall scoreboard, and all the stats, id, names.
                    break;


                case 4:
                    System.out.println("Thank you for playing...");         //input 5 from user will make isPlaying false != opperator means no equal to so if option isnt equal to 5 it will still run
                    break;                                                  //If equal to it shuts down
            }

        }while(option != 4);

    }

}
