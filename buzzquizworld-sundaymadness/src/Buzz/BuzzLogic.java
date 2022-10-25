package Buzz;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * This class contains the logic of the game.
 */
public class BuzzLogic {
    private Presenter newGame ;//= new Buzz.Presenter();
    private CorrectAnswer correctAnswerRound ;//new Buzz.CorrectAnswer();
    private BetRound betRound;// new Buzz.BetRound();


    private FastAnswer fastAnswerRound;
    private StopTimer stopTimerRound;
    private Thermometer thermometerRound;
    private Questions questionPool ;//= new Buzz.Questions();
    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Question> currentQuestionsArray;
    private ArrayList<Player>   players; /// List of game's players
    private int rounds;
    private int currentRoundType;
    private int currentQuestionId;
    private int counterQuestions;
    private Question currentQuestion;
    private SaveData savedata;
    



    public BuzzLogic() throws IllegalAccessException, NoSuchFieldException, IOException {
        newGame = new Presenter();
        questionPool = new Questions();
        players = new ArrayList<Player>();
        correctAnswerRound = new CorrectAnswer();
        betRound = new BetRound();
        fastAnswerRound = new FastAnswer();
        stopTimerRound = new StopTimer();
        thermometerRound = new Thermometer();
        counterQuestions = 1;
    }

    /**
     * Sets the type of round randomly
     * @author Stavros
     */
    public void setCurrentRoundType(){
        currentRoundType = correctAnswerRound.rng(5);
    }

    /**
     * According to an int it returns a String with the type of the round
     * @param randomNumber: The type of the round in int
     * @return String: The type of the round
     * @author Stavros
     */
    public String intToRoundType( int randomNumber){
        switch (randomNumber){
            case 0:
                return "Correct Answer";
            case 1:
                return "Bet Round";
            case 2:
                return "Fast Answer";
            case 3:
                return "Stop Timer";
            case 4:
                return "Thermometer";
        }
        return null;
    }


    /**
     * Getter for fastAnswerRound
     * @return FastAnswer
     * @author Nikitas
     */
    public FastAnswer getFastAnswerRound() {
        return fastAnswerRound;
    }

    /**
     * Getter for fastAnswerRound
     * @return FastAnswer
     * @author Stavros
     */
    public StopTimer getStopTimerRound() {
        return stopTimerRound;
    }

    /**
     * Getter for thermometerRound
     * @return Thermometer
     * @author Stavros
     */
    public Thermometer getThermometerRound() {
        return thermometerRound;
    }

    /**
     * Getter for currentQuestion
     * @return Question
     * @author Nikitas
     */
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Getter for currentRoundType
     * @return int
     * @author Nikitas
     */
    public int getCurrentRoundType() {
        return currentRoundType;
    }

    /**
     * Getter for currentQuestionsArray
     * @return ArrayList<Question>
     * @author Nikitas
     */
    public ArrayList<Question> getCurrentQuestionsArray() {
        return currentQuestionsArray;
    }

    /**
     * Getter for counterQuestions
     * @return int
     * @author Stavros
     */
    public int getCounterQuestions(){
        return counterQuestions;
    }

    /**
     * Getter for correctAnswerRound
     * @return CorrectAnswer
     * @author Stavros
     */
    public CorrectAnswer getCorrectAnswerRound() {
        return correctAnswerRound;
    }

    /**
     * Getter for betRound
     * @return BetRound
     * @author Nikitas
     */
    public BetRound getBetRound() {
        return betRound;
    }

    /**
     * Getter for newGame
     * @return Presenter
     * @author Stavros
     */
    public Presenter getNewGame() {return newGame;}

    /**
     * Getter for players
     * @return ArrayList<Player>
     * @author Stavros
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }

    /**
     * Getter for questionPool
     * @return Questions
     * @author Stavros
     */
    public Questions getQuestions(){
        return questionPool;
    }

    /**
     * Add a new Player in our ArrayList
     * @param name player's name
     * @author Nikitas
     */
    public void addPlayer( String name ){
        players.add( new Player( name ) );
    }

    /**
     * Checks if given number for rounds is sufficient
     * @param rounds Rounds to play the game
     * @return boolean
     */
    public boolean checkSufficient(int rounds ){
        return newGame.questionPoolSufficiency( questionPool, rounds);
    }

    /**
     * Setter for rounds
     * @param rounds int
     * @author Nikitas
     */
    public void setRound( int rounds){
        this.rounds = rounds;
    }


    /**
     * Setter
     * @param playerId int
     * @param answer  String
     */
    public void setPlayerAnswer(int playerId, String answer){
        players.get(playerId).setCurrentAnswer(answer);
    }

    /**
     * Setter
     * @param playerId int
     * @param time int
     */
    public void setPlayerTimerRemaining(int playerId , int time)
    {
        players.get(playerId).setTimePoints(time);
    }

    /**
     * getter
     * @return int
     */
    public int getRound(){
        return this.rounds;
    }

    /**
     * String that says the proper bounds of rounds
     * @return String
     */
    public String maximumRounds(){
        int questionNumber = questionPool.getQuestionsArray().size();
        return "Number of rounds can be < 0 <= " + Integer.toString(questionNumber / 5) + ":";
    }

    /**
     * Creates the currentQuestionsArray
     * @param rounds int
     */
    public void currentQuestions(int rounds)
    {
        currentQuestionsArray = questionPool.createQuestionsPool(rounds);
    }

    /**
     * Set WinSequence of all players to 0
     */
    public void makeZeroWinSeq(){
        for(Player p: players){
            p.setWinSequence(0);
        }
    }

    /**
     * Set answer on fastAnswerRouund
     * @param playerId int
     * @param answer String
     */
    public void setPlayerFastAnswer(int playerId, String answer){
        if(checkFirstAnswer()){
            players.get(playerId).setCurrentAnswer(answer);
        }
        else{
            players.get(playerId).setCurrentAnswer(answer);
            players.get(playerId).setFirst(true);
        }
    }

    /**
     * Checks if someone is faster and has alreadu answer
     * @return boolean
     */
    public boolean checkFirstAnswer(){
        for(Player aPlayer: players){
            if( aPlayer.getIsFirst() ){
                return true;
            }
        }
        return false;
    }

    /**
     * Make all players' field of first equal to false
     */
    public void makeFalseFirst(){
        for(Player aPlayer: players){
            aPlayer.setFirst(false);
        }
    }

    /**
     * Checks if a certain player has answered
     * @param playerId int
     * @return boolean
     */
    public boolean checkNullPlayerAnswer(int playerId){
        if( players.get(playerId).getCurrentAnswer() == null){
            //System.out.println("Hrtha "+currentQuestionsArray.size());
            return false;
        }
        return true;
    }

    /**
     * Make all bets equal to null
     */
    public void makeBetNull(){
        for(Player aPlayer: players){
            aPlayer.setCurrentBet(0);
        }
    }

    /**
     * Check if a certain player has put its bet
     * @param playerId int
     * @return boolean
     */
    public boolean checkBetPlayerAnswer(int playerId){
        if( players.get(playerId).getCurrentBet() == 0){
            //System.out.println("Hrtha");
            return false;
        }
        return true;
    }

    /**
     * Checks if all players have put their bets
     * @return boolean
     */
    public boolean checkBetPlayers(){
        for(Player aPlayer: players){
            if(aPlayer.getCurrentBet() == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Randomly choose a question from the pool
     */
    public void chooseQuestion(){
        if(currentQuestionsArray.size() == 0)
            return;
        ArrayList<String> answers;
        currentQuestionId = correctAnswerRound.rng( currentQuestionsArray.size());
        answers = currentQuestionsArray.get(currentQuestionId).randomAnswers();
        currentQuestion = new Question(currentQuestionsArray.get(currentQuestionId).getTitle(), answers.get(0), answers.get(1), answers.get(2), answers.get(3), currentQuestionsArray.get(currentQuestionId).getCorrectAnswer(), currentQuestionsArray.get(currentQuestionId).getCategory(), currentQuestionsArray.get(currentQuestionId).getImageDir());
    }

    /**
     * getter
     * @return int
     */
    public int getCurrentQuestionId(){
        return currentQuestionId;
    }

    /**
     * Returns some usefuls info for the questtion
     * @return ArrayList<String>
     */
    public ArrayList<String> getQuestionInfo(){
        ArrayList<String> totalInfo = new ArrayList<>();
        totalInfo.add(currentQuestion.getCategory());
        totalInfo.add(currentQuestion.getTitle());
        totalInfo.add(currentQuestion.getAnswer1());
        totalInfo.add(currentQuestion.getAnswer2());
        totalInfo.add(currentQuestion.getAnswer3());
        totalInfo.add(currentQuestion.getAnswer4());
        if(currentQuestion.getImageDir() != null){
            totalInfo.add(currentQuestion.getImageDir());
        }
        return totalInfo;
    }

    /**
     * set alla answers to null
     */
    public void makeNullAnswers(){
        for(Player player: players){
            player.setCurrentAnswer(null);
        }
    }


    /**
     * Sets all players answer to a wrong string in purpose since it is time out
     */
    public void setTimedOutAnswer(){
        for(Player player: players){
            if( player.getCurrentAnswer() == null )
                player.setCurrentAnswer("Timed out");
        }
    }

    /**
     * checks for null answers
     * @return boolean
     */
    public boolean checkNullAnswer(){
        for(Player player: players){
            if(player.getCurrentAnswer() == null){
                return false;
            }
        }
        return true;
    }

    /**
     * setter
     * @param playerId int
     * @param points int
     */
    public void setPlayerBet(int playerId, int points){
        players.get(playerId).setCurrentBet(points);
    }

    /**
     * I am not pretty sure if this is correct
     * @param questionId int
     */
    public void checkPlayerAnswers(int questionId){
        Question currentQuestion = currentQuestionsArray.get(questionId);

    }

    /**
     * remove a question from pool
     * @param questionId int
     */
    public void removeQuestion(int questionId){
        currentQuestionsArray.remove(questionId);
        counterQuestions += 1;
    }

    /**
     * Return the question's category
     * @param list ArrayList<Question>
     * @param index int
     * @return String
     */
    public String getCategory(ArrayList<Question> list , int index)
    {
        return list.get(index).getCategory();
    }

    /**
     * Return the question's title
     * @param list ArrayList<Question>
     * @param index int
     * @return String
     */
    public String getQuestion(ArrayList<Question> list , int index)
    {
        return list.get(index).getTitle();
    }

    /**
     * Return the question's Answer1
     * @param list ArrayList<Question>
     * @param index int
     * @return String
     */
    public String getAnswer1(ArrayList<Question> list , int index)
    {
        return list.get(index).getAnswer1();
    }

    /**
     * Return the question's Answer2
     * @param list ArrayList<Question>
     * @param index int
     * @return String
     */
    public String getAnswer2(ArrayList<Question> list , int index)
    {
        return list.get(index).getAnswer2();
    }

    /**
     * Return the question's Answer3
     * @param list ArrayList<Question>
     * @param index int
     * @return String
     */
    public String getAnswer3(ArrayList<Question> list , int index)
    {
        return list.get(index).getAnswer3();
    }

    /**
     * Return the question's Answer4
     * @param list ArrayList<Question>
     * @param index int
     * @return String
     */
    public String getAnswer4(ArrayList<Question> list , int index)
    {
        return list.get(index).getAnswer4();
    }

    /**
     * Return the question's correctAnswer
     * @param list ArrayList<Question>
     * @param index int
     * @return String
     */
    public String getCorrectAnswer(ArrayList<Question> list , int index) {
        return list.get(index).getCorrectAnswer();
    }

    public void Savedatatxt(ArrayList<Player> players) throws IOException {
        savedata = new SaveData(players);
    }


}
