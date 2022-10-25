package Buzz;

import Buzz.BetRound;
import Buzz.CorrectAnswer;

import java.io.IOException;
import java.util.ArrayList;
/**
 * This program implements a basic Buzz World Game.
 * In this version, only single player mode is available.
 * There are currently only 10 questions imported but
 * there is an upcoming update of this project.
 *
 *  MISXOS STAVROS    AEM 3257
 *  MARAGKOS NIKITAS  AEM 3562
 */
public class Main {
    /**
     * @author Stavros
     */
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {

        Presenter newGame = new Presenter();
        CorrectAnswer correctAnswerRound = new CorrectAnswer();
        BetRound betRound = new BetRound();
        ArrayList<Player> players = new ArrayList<Player>();
        Questions questionPool = new Questions();
        ArrayList<Question> currentQuestionsArray;

        players.add(new Player());
        int rounds = newGame.initializeGame( players.get(0) );
        currentQuestionsArray = questionPool.createQuestionsPool( rounds );

        //Creating a loop that "casts" game's rounds.
        for (int i = 1; i <= rounds; i++)
        {
            if(newGame.roundTypeSelection() == 0)
            {
                correctAnswerRound.playRound( players, currentQuestionsArray);
            }
            else
            {
                betRound.playRound(players, currentQuestionsArray);
            }
        }



    }
}
