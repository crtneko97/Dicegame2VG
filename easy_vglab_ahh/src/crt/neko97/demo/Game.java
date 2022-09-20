package crt.neko97.demo;

public class Game {
    public int rounds = 0;
    Skanner skanner = new Skanner();
    Dice dice;
    public Game(int rounds){
        this.rounds = rounds;
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public void startMenu(){
        System.out.println(ANSI_GREEN + "\n\nSimons VG dice game\n" +
                "1: Create a player\n" +
                "2: Play a game of dice!\n" +
                "3: Show playerlist and scoreboard\n" + ANSI_RESET + ANSI_RED +
                "4: Exit\n");
    }

    public void roundNumber(){
        System.out.print("How many rounds: ");
        rounds = skanner.scanInt();
    }

    public void setRounds(int rounds){
        this.rounds = rounds;
    }
    public int getRounds(){
        return rounds;
    }

}
