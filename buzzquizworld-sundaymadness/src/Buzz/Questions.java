package Buzz;

import Buzz.Question;

import java.util.ArrayList;
import java.util.Collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Temporary Repository of Buzz.Questions
/**
 *
 * @author Stavros
 * @author Nikitas
 */
public class Questions {

    String quest1  = "General//<html>What year did the Titanic sink <br/> in the Atlantic Ocean on 15 April,<br/> on its maiden voyage from Southampton?</html>//" +
                     "1912//1922//1910//1920//1912";
    String quest2  = "General//<html>What is the name of the biggest <br/> technology company in South Korea?</html>//" +
            "Huawei//Xiaomi//Samsung//LG//Samsung";
    String quest3  = "Science//<html>If the Earth were made into a black hole,<br/> what would be the diameter of its event horizon?</html>//" +
            "22mm//22cm//22dm//22m//22mm";
    String quest4  = "Science//<html>To the nearest 1 per cent, what percentage of the mass<br/> of the solar system is in the Sun?</html>//" +
            "96%//97%//98%//99%//99%";
    String quest5  = "Music//<html>What is the name of the band <br/>with the following members:<br/> John Deacon, Brian May, Freddie Mercury,<br/> Roger Taylor?</html>//" +
            "The Beatles//Pink Floyd//Queen//Coldplay//Queen";
    String quest6  = "Sports//Which club won the 1986 FA Cup final?//" +
            "Liverpool//Arsenal//Manchester United//Chelsea//Liverpool";
    String quest7  = "World History//When did the First World War end?//" +
            "1912//1913//1918//1919//1918";
    String quest8  = "World History//When did the Second World War end?//" +
            "1944//1945//1946//1947//1945";
    String quest9  = "Board Games//<html>Which board game consists of 40 spaces containing 28 properties,<br/> four railroads, two utilities, three Chance spaces,<br/> " +
            "three Community Chest spaces, <br/>a Luxury Tax space, an Income Tax space, <br/>and the four corner squares: <br/>GO, Jail, Free Parking, and Go to Jail?</html>//" +
            "Jumanji//Monopoly//UNO//Pictionary//Monopoly";
    String quest10 = "Board Games//What is the grid size on a game of Scrabble?//" +
            "14.5 x 14.5//15 x 15//15.5 x 15.5//16 x 16//15 x 15";

    Question question1  = new Question(quest1);
    Question question2  = new Question(quest2);
    Question question3  = new Question(quest3);
    Question question4  = new Question(quest4);
    Question question5  = new Question(quest5);
    Question question6  = new Question(quest6);
    Question question7  = new Question(quest7);
    Question question8  = new Question(quest8);
    Question question9  = new Question(quest9);
    Question question10 = new Question(quest10);

    private ArrayList<Question> questionsArray;

    //The constructor will put all available question in an ArrayList Pool
    //This list will be called on each of the Round-Classes

    public Questions() throws FileNotFoundException, IOException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
    {

        questionsArray = new ArrayList<>();

        BufferedReader in = new BufferedReader(new FileReader ("questionPool"));
        String l;

        while ( (l = in.readLine()) != null )
        {
            Question question = new Question(l);
            questionsArray.add(question);
        }

    }

    //Getter for the Arraylist

    /**
     * Getter function of the questionsArray
     * @return The current pool of questions
     * @author Stavros
     */
    public ArrayList<Question> getQuestionsArray(){
        return questionsArray;
    }

    /**
     * Method that must be called before each game. It creates a random subset of Buzz.Question-Objects.
     * The length of the ArrayList is rounds * 5, since each round has 5 questions.
     * @param rounds: An int that states the number of rounds that will be played in the certain game.
     * @return A ArrayList of Buzz.Question that is a random subset of the bigger pool of Buzz.Questions. It
     * must be created before the start of each game.
     * @author Nikitas
     */
    public ArrayList<Question> createQuestionsPool(int rounds){
        ArrayList<Question> questionsPool = new ArrayList<>();
        ArrayList<Integer> idsList = new ArrayList<>();
        for(int i = 0; i < this.questionsArray.size(); i++ ){
            idsList.add(i);
        }
        Collections.shuffle(idsList);
        for(int i = 0; i < rounds * 5; i++){
            questionsPool.add( questionsArray.get( idsList.get(i) ) ) ;
        }
        return questionsArray;
    }

}
