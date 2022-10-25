package Buzz;

import Buzz.BasicRound;

import java.util.ArrayList;

/**
 * A certain Round type that extends the abstract Buzz.BasicRound.
 * In this type the player just plays the questions. If he answers
 * correct he wins points equal to correctAnswerPoints. If not
 * nothing is done.
 * @author Nikitas
 */
public class CorrectAnswer extends BasicRound {
    private int correctAnswerPoints;


    /**
     * A simple constructor that sets correctAnswerPoints equal to 1000.
     * @author Nikitas
     */
    public CorrectAnswer(){
        this.correctAnswerPoints = 1000;
    }

    /**
     * A constructor tha sets correctAnswerPoints equal to input.
     * @param correctAnswerPoints : The points that the player will win by choosing the correct answer.
     * @author Nikitas
     */
    public CorrectAnswer( int correctAnswerPoints){
        this.correctAnswerPoints = correctAnswerPoints;
    }

    /**
     * Getter
     * @return An int that represents the reward of choosing the correct answer.
     * @author Nikitas
     */
    public int getReward(){
        return this.correctAnswerPoints;
    }

    /**
     * Setter
     * @param reward: Int that represents the reward of choosing the correct answer.
     * @author Nikitas
     */
    public void setReward(int reward){
        this.correctAnswerPoints = reward;
    }

    /**
     * It is a 5-time for loop that a single player plays a Correct type round.
     * The question is selected randomly and after it is removed from the pool
     * so it cannot be played in the same game.
     * @param players: Buzz.Player object for the first part. For the second it will be a list of Buzz.Player's objects.
     * @param pool:   An ArrayList of Buzz.Question's objects that has been selected for the same game.
     * @author Nikitas
     */
    public void playRound(ArrayList<Player> players , ArrayList<Question> pool){
        super.playRound(players, pool);
    }

    /**
     * Buzz.Player plays a correct type question. If he choose the correct answer
     * he will win points. At the end the Buzz.Player's points are presented.
     * @param players:   Buzz.Player that will play the certain question.
     * @param question: The certain question that will be played.
     * @author Nikitas
     */
    @Override
    protected void playQuestion(ArrayList<Player> players, Question question){

        boolean answer = question.printQuestion();
        if(answer){
            players.get(0).addPoints( correctAnswerPoints );
        }
        players.get(0).presentPlayer();
    }

    /**
     * Updates all players points corresponding to their answers
     * @param players ArrayList<Player>
     * @param question Question
     */
    protected void checkPlayerAnswers(ArrayList<Player> players, Question question){

        for(Player aPlayer: players){
            if( question.correctAnswer(aPlayer.getCurrentAnswer()) ){
                aPlayer.addPoints( correctAnswerPoints );
            }
        }

    }


}
