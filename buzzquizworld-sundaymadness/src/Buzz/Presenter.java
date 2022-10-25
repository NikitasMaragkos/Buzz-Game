package Buzz;

import Buzz.Player;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Stavros
 */
public class Presenter {
    private final Scanner input = new Scanner(System.in);
    private Questions questionPool = new Questions();
    private Random rand = new Random();

    private int players;
    private int rounds;
    private int roundTypes = 2; //For now we only have correct answer rounds  and bet rounds.

    public Presenter() throws IllegalAccessException, NoSuchFieldException, IOException {

    }
    //Method to initialize the game in Buzz.Main.
    //Set players number, set their names and points and how many rounds will be played.

    /**
     * Method to initialize the game in Buzz.Main.
     * Set players number, set their names and points and how many rounds will be played.
     * @param player: Buzz.Player Object
     * @return The number of rounds that will be played
     * @author Stavros
     */
    public int initializeGame(Player player)
    {
        welcomeMessage();
        numberOfPlayers();
        askName();
        player.setName(input.next());
        player.setPoints(0);
        askRounds(player.getName());
        rounds = questionsSufficiency();
        return rounds;
    }



    /**
     * Declaring if there will be 1 or 2 players
     * @author Stavros
     */
    private void numberOfPlayers ()
    {
        System.out.println("How many players will play?");
        players = input.nextInt();
        while(players<=0 || players >1) {
            System.out.println("Not available!");
            players = input.nextInt();
        }
    }
    //Checking if there are enough questions for the player's choice of rounds

    /**
     * This function checks if there are sufficient amount of questions for the player(s) to play.
     * @return True if there are enough questions to play and false otherwise
     * @author Nikitas
     */
    public boolean questionPoolSufficiency(Questions questionPool, int rounds) {

        int poolSize = questionPool.getQuestionsArray().size();
        if( (poolSize < 5 * rounds) || ( rounds <= 0 ) )
            return false;
        return true;
    }

    /**
     * This function checks if there are sufficient amount of questions for the player(s) to play.
     * On each version the pool of questions will be increased.
     * @return How many rounds will be played
     * @author Stavros
     */
    private int questionsSufficiency()
    {
        int roundNumber = input.nextInt();
        int questions = questionPool.getQuestionsArray().size();
        if(roundNumber*5 >questions)
        {
            do{
                System.out.println("Not enough questions to play that many rounds.");
                System.out.println("Please select a smaller number of rounds.(<="+ Integer.toString(questions / 5) + ").");
                roundNumber = input.nextInt();
            } while (roundNumber*5 > questions);
            return roundNumber;
        }
        else
        {
            System.out.println("Rounds chosen: " + roundNumber);
        }
        return roundNumber;
    }

    /**
     * This function selects which kind of round will the player play
     * @return Which type of round will be next, randomly
     * @author Stavros
     */
    public int roundTypeSelection()
    {
        int next = rand.nextInt(roundTypes);
        if(next == 0)
        {
            System.out.println("Type of round: Correct Answer");
        }
        else
        {
            System.out.println("Type of round: Bet Round");
        }
        return next;
    }

    /**
     * Welcome message for Start menu
     * @author Nikitas
     */
    private void welcomeMessage(){
        System.out.println("Hello, let's play Buzz!");
    }

    /**
     * Buzz.Question to help on game initialization
     * @author Nikitas
     */
    private void askName(){
        System.out.println("What is your name?");
    }

    /**
     * Function where the player chooses how many rounds will play.
     * @param name: String that is Buzz.Player's name.
     * @author Nikitas
     */
    private void askRounds(String name){
        System.out.println("How many rounds would you like to play, "
                + name +"?");
    }

}
