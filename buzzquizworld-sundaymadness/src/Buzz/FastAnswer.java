package Buzz;

import Buzz.BasicRound;
import java.util.ArrayList;
import java.util.List;

/**
 * A certain Round type that extends the abstract Buzz.BasicRound.
 * In this type the player just plays the questions as fast as
 * she/he can. The faster player who answered correctly is rewarded
 * with 1000 points. The second correct player wins 500 points.
 * @author Nikitas
 */
public class FastAnswer extends BasicRound {



   // private List<Pair<Integer,String>> fasterAnswer = new ArrayList<>();
    private int fasterReward;
    private int secondReward;


    /**
     * A simple constructor that sets correctAnswerPoints equal to 1000.
     * @author Nikitas
     */
    public FastAnswer(){
        this.fasterReward = 1000;
        this.secondReward = 500;
    }


    public int getFasterReward() {
        return fasterReward;
    }

    public int getSecondReward() {
        return secondReward;
    }

    public void setFasterReward(int fasterReward) {
        this.fasterReward = fasterReward;
    }

    public void setSecondReward(int secondReward) {
        this.secondReward = secondReward;
    }

    /**
     *
     * @param players: ArrayList of Buzz.Player-Objects that play the round
     * @param pool: ArrayList of Buzz.Question-Objects from where randomly
     *            5 questions will pe played.
     */
    public void playRound(ArrayList<Player> players , ArrayList<Question> pool){
        super.playRound(players, pool);
    }

    /**
     * Id of first player
     * @param players ArrayList<Player>
     * @return int
     */
    public int findFirst(ArrayList<Player> players ){
        int firstId = 0;
        for(Player aPlayer: players){
            if(aPlayer.getIsFirst()){
                return firstId;
            }
            firstId += 1;
        }
        return firstId;
    }

    /**
     * Updates all players points corresponding to their answers
     * @param players ArrayList<Player>
     * @param question Question
     */
    protected void checkPlayerAnswers(ArrayList<Player> players, Question question){

        boolean fasterWins = false;
        int firstId = findFirst(players);
        int counter = 0;

        if( question.correctAnswer(players.get(firstId).getCurrentAnswer()) ){
            players.get(firstId).addPoints(fasterReward);
            fasterWins = true;
        }


        for(Player aPlayer: players) {

            if(counter == firstId){
                counter += 1;
                continue;
            }
            counter += 1;
            if (question.correctAnswer(aPlayer.getCurrentAnswer())) {
                if(aPlayer.getIsFirst()){
                    aPlayer.addPoints( fasterReward );
                    fasterWins = true;
                }
                else{
                    if(fasterWins) {
                        aPlayer.addPoints(secondReward);
                    }
                    else{
                        aPlayer.addPoints(fasterReward);
                        fasterWins = true;
                    }
                }
            }
        }

    }

}
