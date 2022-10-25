package Buzz;

import java.util.ArrayList;

/**
 *
 * @author Nikitas
 */
public class Player {
    private String name;
    private double points;
    private String currentAnswer;
    private int currentBet;
    private int timePoints;
    private int winSequence = 0;



    private boolean isFirst = false;



    /**
     * The simple constructor for each Buzz.Player-object of the game.
     * Default name-->"BuzzLightYear", default points-->0.
     * @author Nikitas
     */
    public Player() {
        this.name = "BuzzLightYear";
        this.points = 0;
        this.currentAnswer = null;
        this.currentBet = 0;
    }

    /**
     * The constructor for each Buzz.Player-object of the game
     * @param name:   String that is Buzz.Player's name.
     * @param points: Int that is Buzz.Player's points.
     * @author Nikitas
     */
    public Player( String name , int points ){
        this.name = name;
        this.points = points;
        this.currentAnswer = null;
        this.currentBet = 0;
    }

    /**
     * The constructor for each Buzz.Player-object of the game
     * @param name:   String that is Buzz.Player's name.
     * @author Nikitas
     */
    public Player( String name){
        this.name   = name;
        this.points = 0;
        this.currentAnswer = null;
        this.currentBet = 0;
    }

    /**
     * Setter
     * @param name: String Buzz.Player's name
     * @author Nikitas
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Setter
     * @param points: Int that is Buzz.Player's points.
     * @author Nikitas
     */
    public void setPoints(float points){
        this.points = points;
    }

    public void setCurrentAnswer(String answer){currentAnswer = answer;}

    public void setCurrentBet(int bet){currentBet = bet;}

    /**
     * Getter
     * @return Players's name.
     * @author Nikitas
     */
    public String getName(){
        return name;
    }

    /**
     * Getter
     * @return Players's points.
     * @author Nikitas
     */
    public double getPoints(){
        return points;
    }

    public String getCurrentAnswer(){return currentAnswer;}

    public int getCurrentBet(){return currentBet;}

    /**
     * Add-Subtract points to the Buzz.Player.
     * @param points: must be int, Positive--> Addition, Negative--> Subtraction
     * @author Nikitas
     */
    public void addPoints(double points){this.points += points; }

    /**
     * Presents Buzz.Player's name and points.
     * @author Nikitas
     */
    public void presentPlayer(){
        System.out.println( this.getName() + " you have " + this.getPoints() + " points.");
    }


    public double getTimePoints() {
        return timePoints;
    }

    public int getWinSequence() {
        return winSequence;
    }
    public void setTimePoints(int timePoints) {
        this.timePoints = timePoints;
    }

    public void setWinSequence() {
        this.winSequence++;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean getIsFirst() {
        return isFirst;
    }

    public boolean checkNullAnswer(ArrayList<Player> players){
        for(Player aPlayer: players){
            if(aPlayer.getCurrentAnswer() == null){
                return false;
            }
        }
        return true;
    }

    public void setWinSequence(int winSequence) {
        this.winSequence = winSequence;
    }
}