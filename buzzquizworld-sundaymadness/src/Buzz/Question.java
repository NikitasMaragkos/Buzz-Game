package Buzz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 *
 * @author Stavros
 */
public class Question {
    private  String category;
    private  String title;
    private  String answer1, answer2, answer3, answer4;
    private  String correctAnswer;
    private  String imageDir;

    /**
     * The constructor for each Buzz.Question-object of the game
     * @param title:   String. Buzz.Question's title
     * @param answer1: String. Buzz.Question's first possible answer
     * @param answer2: String. Buzz.Question's second possible answer
     * @param answer3: String. Buzz.Question's third possible answer
     * @param answer4: String. Buzz.Question's fourth possible answer
     * @param correctAnswer: String. Buzz.Question's correct answer
     * @param category: String. Buzz.Question's category
     * @author Stavros
     */
    public Question(String title, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String category)
    {
        this.title = title;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.imageDir = null;
    }


    public Question(String title, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String category, String image)
    {
        this.title = title;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.imageDir = image;
    }

    /**
     *
     * @param info: All the information that needed for a question, separated by "//"
     * @author Nikitas
     */
    public Question(String info){
        String[] subStrings;
        subStrings = info.split("//");
        this.setCategory(subStrings[0]);
        this.setTitle(subStrings[1]);
        this.setAnswer1(subStrings[2]);
        this.setAnswer2(subStrings[3]);
        this.setAnswer3(subStrings[4]);
        this.setAnswer4(subStrings[5]);
        this.setCorrectAnswer(subStrings[6]);
        if(subStrings.length == 8 ){
            this.setImageDir(subStrings[7]);
        }
        else{
            this.setImageDir(null);
        }
    }

    /**
     *
     * @return The category of the question
     * @author Stavros
     */
    public String getCategory() {return category;}

    /**
     *
     * @return The question itself
     * @author Stavros
     */
    public String getTitle() {return title;}

    /**
     *
     * @return First possible Answer
     * @author Stavros
     */
    public String getAnswer1() {return answer1;}

    /**
     *
     * @return Second possible Answer
     * @author Stavros
     */
    public String getAnswer2() {return answer2;}

    /**
     *
     * @return Third possible Answer
     * @author Stavros
     */
    public String getAnswer3() {return answer3;}

    /**
     *
     * @return Fourth possible Answer
     * @author Stavros
     */
    public String getAnswer4() {return answer4;}

    /**
     *
     * @return The correct answer of the question
     * @author Stavros
     */
    public String getCorrectAnswer() {return correctAnswer;}

    public String getImageDir(){return imageDir;}

    /**
     * Setter
     * @param category: String. Buzz.Question's category.
     * @author Stavros
     */
    public void setCategory(String category) {this.category = category;}

    /**
     *
     * @param title: String. Buzz.Question's title.
     * @author Stavros
     */
    public void setTitle(String title) {this.title = title;}

    /**
     * Setter
     * @param answer1: String. Buzz.Question's first possible answer.
     * @author Stavros
     */
    public void setAnswer1(String answer1) {this.answer1 = answer1;}

    /**
     * Setter
     * @param answer2: String. Buzz.Question's second possible answer.
     * @author Stavros
     */
    public void setAnswer2(String answer2) {this.answer2 = answer2;}

    /**
     * Setter
     * @param answer3: String. Buzz.Question's third possible answer.
     * @author Stavros
     */
    public void setAnswer3(String answer3) {this.answer3 = answer3;}

    /**
     * Setter
     * @param answer4: String. Buzz.Question's fourth possible answer.
     * @author Stavros
     */
    public void setAnswer4(String answer4) {this.answer4 = answer4;}

    /**
     * Setter
     * @param correctAnswer: String. Buzz.Question's correct answer.
     * @author Stavros
     */
    public void setCorrectAnswer(String correctAnswer) {this.correctAnswer = correctAnswer;}

    public void setImageDir(String image){this.imageDir = image;}


    /**
     * This functions presents the question to the players
     * but before that is shuffles the possible answers.
     * @return The shuffled ArrayList of answers
     * @author Nikitas
     */
    public ArrayList<String> presentQuestionRandom()
    {
        ArrayList<String> answers = randomAnswers();

        System.out.println(this.getTitle());
        System.out.println();
        System.out.println("Answers");
        System.out.println("1. " + answers.get(0));
        System.out.println("2. " + answers.get(1));
        System.out.println("3. " + answers.get(2));
        System.out.println("4. " + answers.get(3));

        return answers;
    }

    public ArrayList<String> randomAnswers()
    {
        ArrayList<String> answers = new ArrayList<>();
        answers.add( this.getAnswer1() );
        answers.add( this.getAnswer2() );
        answers.add( this.getAnswer3() );
        answers.add( this.getAnswer4() );
        Collections.shuffle(answers);
        return answers;
    }


    /**
     * The function that prints every question when asked everywhere inside the program
     * After that, it checks if the question is correct or wrong,
     * and then it's printing a feedback message.
     * @return True or False
     * @author Stavros
     */
    public boolean printQuestion()
    {
        Scanner input = new Scanner(System.in);
        boolean correct;
        ArrayList<String> shuffledAnswers = presentQuestionRandom();
        System.out.println("Your answer is: (Pick 1,2,3,4)");
        int answer = input.nextInt();
        correct = checkAnswer(answer, shuffledAnswers);
        if(correct){
            System.out.println("Your answer is correct.");
            return true;
        }
        else{
            System.out.println("Your answer is wrong.");
            return false;
        }

    }

    /**
     * Checks if player's chosen answer is correct, returning true or false.
     * @param answer: An int that must be 1,2,3,4. It is basically Buzz.Player's answer.
     * @return True or False
     * @author Stavros
     */
    private boolean checkAnswer(int answer, ArrayList<String> shuffledAnswers) {
        Scanner input = new Scanner(System.in);
        int newAnswer = answer;
        boolean correct;
        while(newAnswer!=1 && newAnswer!=2 && newAnswer!=3 && newAnswer!=4)
        {
            System.out.println("Please pick a legal choice: (Pick 1,2,3,4)");
            newAnswer = input.nextInt();
        }
        if(newAnswer == 1){
            correct = correctAnswer(shuffledAnswers.get(0));
        }
        else if(newAnswer == 2){
            correct = correctAnswer(shuffledAnswers.get(1));
        }
        else if(newAnswer == 3){
            correct = correctAnswer(shuffledAnswers.get(2));
        }
        else{
            correct = correctAnswer(shuffledAnswers.get(3));
        }
        return correct;
    }

    /**
     * Comparing players choice with the actual correct answer of the question.
     * @param answer: String
     * @return True or False, depending on players choice
     * @author Stavros
     */
    protected boolean correctAnswer(String answer)
    {
        return answer.equals(this.getCorrectAnswer());
    }


}
