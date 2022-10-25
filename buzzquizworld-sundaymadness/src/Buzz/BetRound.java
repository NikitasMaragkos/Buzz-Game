package Buzz;

import Buzz.BasicRound;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * A certain Round type that extends the abstract Buzz.BasicRound.
 * In this type the player sees the category of the question
 * and then he can select the betting points to play.
 * @author  Nikitas
 */
public class BetRound extends BasicRound {
    private int bet1;
    private int bet2;
    private int bet3;
    private int bet4;

    /**
     * The simple constructor for each Buzz.BetRound-object of the game.
     * Default bets: 250, 500, 750, 1000.
     * @author Nikitas
     */
    public BetRound()
    {
        this.bet1 = 250;
        this.bet2 = 500;
        this.bet3 = 750;
        this.bet4 = 1000;
    }

    /**
     * The constructor that has certain betting options for the
     * Buzz.BetRound-object that will be created.
     * @param bet1: Int that is bet1
     * @param bet2: Int that is bet2
     * @param bet3: Int that is bet3
     * @param bet4: Int that is bet4
     * @author Nikitas
     */
    public BetRound( int bet1, int bet2, int bet3, int bet4 )
    {
        this.bet1 = bet1;
        this.bet2 = bet2;
        this.bet3 = bet3;
        this.bet4 = bet4;
    }

    /**
     * Setter.
     * @param bet1: An int that will be the first betting option.
     * @author Nikitas
     */
    public void setBet1( int bet1 ){
        this.bet1 = bet1;
    }

    /**
     * Setter.
     * @param bet2: An int that will be the second betting option.
     * @author Nikitas
     */
    public void setBet2( int bet2 ){
        this.bet2 = bet2;
    }

    /**
     * Setter.
     * @param bet3: An int that will be the third betting option.
     * @author Nikitas
     */
    public void setBet3( int bet3 ){
        this.bet3 = bet3;
    }

    /**
     * Setter.
     * @param bet4: An int that will be the fourth betting option.
     * @author Nikitas
     */
    public void setBet4( int bet4 ){
        this.bet4 = bet4;
    }

    /**
     * Getter
     * @return An int that is the first betting option.
     * @author Nikitas
     */
    public int getBet1( ){
       return this.bet1;
    }

    /**
     * Getter
     * @return An int that is the second betting option.
     * @author Nikitas
     */
    public int getBet2( ){
        return this.bet2;
    }

    /**
     * Getter
     * @return An int that is the third betting option.
     * @author Nikitas
     */
    public int getBet3( ){
        return this.bet3;
    }

    /**
     * Getter
     * @return An int that is the fourth betting option.
     * @author Nikitas
     */
    public int getBet4( ){
        return this.bet4;
    }

    /**
     * It is a 5-time for loop where a Buzz.Player plays a random question( rng )
     * from the pool. When the question is played we remove it so we
     * cannot play it in the same game.
     * @param players: ArrayList of Buzz.Player-Objects that play the round.
     * @param pool:   The pool of question that have been created for this particular game
     * @author Nikitas
     */
    public void playRound(ArrayList<Player> players, ArrayList<Question> pool)
    {
        super.playRound( players, pool);
    }

    /**
     * The player plays a single question. First we present the category of the question in order
     * the player to decide the available bet option. Then the question is presented and the player
     * chooses his answer. If it is correct he will obtain the betting points, otherwise he will
     * subtract them from his points. The player's points are presented at the end.
     * @param players: ArrayList of Buzz.Player-Objects that will play the game.
     * @param question:   The certain question that has been selected.
     * @author Nikitas
     */
    @Override
    protected void playQuestion(ArrayList<Player> players, Question question)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> choices = new ArrayList<Integer>();
        ArrayList<Integer> betPoints = new ArrayList<Integer>();

        presentBetOptions( question );
        choices.add(input.nextInt());
        betPoints.add( checkBet( choices.get(0) ) );
        boolean answer = question.printQuestion();
        if(answer){
            players.get(0).addPoints( betPoints.get(0) );
        }
        else{
            players.get(0).addPoints( -1 * betPoints.get(0) );
        }
        players.get(0).presentPlayer();
    }

    /**
     * This method presents the available betting option and before that the
     * category of the question that will be played later.
     * @param question: Buzz.Question-object that is the question that will be played after
     * @author Nikitas
     */
    private void presentBetOptions( Question question) {

        System.out.println("The category of the question is: " + question.getCategory());
        System.out.println("How many points you want to bet?");
        System.out.printf("1. %d%n", getBet1());
        System.out.printf("2. %d%n", getBet2());
        System.out.printf("3. %d%n", getBet3());
        System.out.printf("4. %d%n", getBet4());
        System.out.println("Your choice is: (Pick 1,2,3,4)");
    }

    /**
     * We make sure that the player chooses one of the available betting options and return it.
     * @param  choice: An int that is 1 or 2 or 3 or 4.
     * @return betPoints: An int that is the betting points.
     * @author Nikitas
     */
    private int checkBet(int choice) {
        Scanner input = new Scanner(System.in);
        int newChoice = choice;
        int betPoints;
        while(newChoice!=1 && newChoice!=2 && newChoice!=3 && newChoice!=4)
        {
            System.out.println("Please pick a legal choice: (Pick 1,2,3,4)");
            newChoice = input.nextInt();
        }

        if(newChoice == 1){
            betPoints = this.getBet1();
        }
        else if(newChoice == 2){
            betPoints = this.getBet2();
        }
        else if(newChoice == 3){
            betPoints = this.getBet3();
        }
        else{
            betPoints = this.getBet4();
        }

        return betPoints;
    }

    protected void checkPlayerAnswers(ArrayList<Player> players, Question question){
        for(Player aPlayer: players){
            if( question.correctAnswer(aPlayer.getCurrentAnswer()) ){
                aPlayer.addPoints( aPlayer.getCurrentBet() );
            }
            else{
                aPlayer.addPoints( - aPlayer.getCurrentBet() );
            }
        }
    }


}
