package Buzz;

import java.util.ArrayList;

public class Thermometer extends  BasicRound{
    private int fiveCorrectAnswersPoints;


    public Thermometer()
    {
        fiveCorrectAnswersPoints = 5000;
    }

    public int getFiveCorrectAnswersPoints() {
        return fiveCorrectAnswersPoints;
    }

    public void playRound(ArrayList<Player> players , ArrayList<Question> pool){
        super.playRound(players, pool);
    }

    public void playQuestion(ArrayList<Player> players, Question question)
    {
        boolean answer = question.printQuestion();
        if(answer){
            players.get(0).addPoints( getFiveCorrectAnswersPoints() );
            if(getFiveCorrectAnswersPoints() ==5)
            {
                players.get(0).setPoints(fiveCorrectAnswersPoints);
            }
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
            if(question.correctAnswer(aPlayer.getCurrentAnswer()))
            {
                aPlayer.setWinSequence();
            }
            if( aPlayer.getWinSequence() == 5)
            {
                aPlayer.addPoints( 5000 );
            }
        }

    }
}
