package Buzz;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StopTimer extends BasicRound{

    private float initialTime;
    private float stopTimerMultiplier;
    private float currentTime;


    public StopTimer()
    {
        initialTime = 500;
        stopTimerMultiplier = (float) 0.2;
        currentTime = initialTime;
    }

    public void startTimer() {

        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int second = (int)initialTime;

            @Override
            public void run() {

                if (second != 0) {
                    second = second - 100;
                    currentTime = currentTime - 100;
                } else if(second ==0) {
                    timer.cancel();
                    //timer.purge();

                }
            }
        }, 0, 100);
    }

    public void playRound(ArrayList<Player> players , ArrayList<Question> pool){
        super.playRound(players, pool);
    }

    /**
     * Updates all players points corresponding to their answers
     * @param players ArrayList<Player>
     * @param question Question
     */
    protected void checkPlayerAnswers(ArrayList<Player> players, Question question){
        for(Player aPlayer: players){
            if( question.correctAnswer(aPlayer.getCurrentAnswer()) ) {
                aPlayer.addPoints(aPlayer.getTimePoints() * stopTimerMultiplier);
            }
        }
    }
}
