package Buzz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * An abstract class that describes a Round. Any other type of round
 * that the programmer wants to implement must simply extend this one.
 * @author Nikitas
 */
public abstract class BasicRound {

    /**
     * The general Round that in any Type of round will have
     * this certain structure. In a 5 step for-loop randomly a
     * questions from the pool is chosen to be played. After that
     * it is deleted from the pool.
     * @param players: ArrayList of Buzz.Player-Objects that play the round
     * @param pool: ArrayList of Buzz.Question-Objects from where randomly
     *            5 questions will pe played.
     * @author Nikitas
     */
    public void playRound(ArrayList<Player> players, ArrayList<Question> pool)
    {
        for(int i = 0; i < 5; i++){
            int rng = this.rng(pool.size());
            playQuestion(players , pool.get(rng));
            pool.remove(rng);
        }
    }

    /**
     * An abstract method that it implements the question.
     * It will Overwritten by any other method of corresponding
     * round type.
     * @param players: ArrayList of Buzz.Player-Objects that play the question
     * @param question: Buzz.Question-Object that is played.
     * @author Nikitas
     */
    protected void playQuestion(ArrayList<Player> players, Question question)
    {
    }

    /**
     * A random number generator that randomizes the choice of the questions from the pool.
     * It is used on each of the Round-classes
     * @param size: An int that is the upper bound of the random generator number.
     * @return A random number between 0 and the number of questions available after each one played
     * @author Stavros
     */
    public int rng(int size)
    {
        Random rand = new Random();
        int rng = rand.nextInt( size );
        return rng;
    }


    public void countDownTimer(int secs, ArrayList<Player> players, JLabel label) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int second = secs;
            //Robot robot = new Robot();

            @Override
            public void run() {

                if( players.get(0).checkNullAnswer(players) ){
                    timer.cancel();
                }

                if (second != 0) {
                    label.setText(Integer.toString(second));
                    second = second - 100;
                } else if(second ==0) {
                    label.setText("Time out!");
                    for(Player player: players){
                        if(player.getCurrentAnswer() == null){
                            player.setCurrentAnswer("1");
                        }
                    }
                    timer.cancel();
                    //robot.keyPress(1);
                    //timer.purge();
                }
            }
        }, 0, 100);
    }

    //public void handleKeys(){}
}
