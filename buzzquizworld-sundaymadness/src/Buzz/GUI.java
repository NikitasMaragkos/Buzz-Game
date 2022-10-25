package Buzz;

import Buzz.BuzzLogic;
import Buzz.images.Resource;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {
    private JLabel[] playersInfo;
    private BuzzLogic logic = new BuzzLogic();
    private JLabel buzz, WelcomeMessage, TypeOfRound, QuestionCategory,QuestionImage, QuestionTitle,Answer1,Answer2,Answer3,Answer4,CorrectAnswer, timerLabel;
    private JFrame frame;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;
    private JButton singlePlayer, twoPlayers;
    private int numberOfQuestionsRound = 5;
    private String player1, player2;
    private double points1 ,points2;


    /**
     * The constructor of GUI. Creates 2 basic panels, with sub-panels for all the game.
     * Also creates and the appropriate handle-keys
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws IOException
     * @author Stavros-Nikitas
     */
    public GUI() throws IllegalAccessException, NoSuchFieldException, IOException {

        //~~~~ Main Frame ~~~~
        frame = new JFrame("Buzz game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setResizable(false);

        //~~~~ Main Panels ~~~~

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();


        panel1.setBackground(Color.red);
        panel2.setBackground(Color.blue);
        panel3.setBackground(Color.white);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.cyan);

        panel1.setPreferredSize(new Dimension(100, 50));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(300, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));

        frame.add(panel1, BorderLayout.NORTH);
        //frame.add(panel2,BorderLayout.EAST);
        frame.add(panel3, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(panel5, BorderLayout.CENTER);

        buzz = new JLabel();
        buzz.setIcon(new ImageIcon(Resource.getURL("Buzz.jpg")));
        panel3.add(buzz);
        //~~~~~   Sub-Panels   ~~~~~~~~

        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();

        panel5.setLayout(new BorderLayout());

        panel6.setPreferredSize(new Dimension(50, 50));
        panel7.setPreferredSize(new Dimension(150, 50));
        panel8.setPreferredSize(new Dimension(50, 50));
        panel9.setPreferredSize(new Dimension(50, 50));
        panel10.setPreferredSize(new Dimension(50, 50));

        panel6.setBackground(Color.white);
        panel7.setBackground(Color.lightGray);
        panel8.setBackground(Color.blue);
        panel9.setBackground(Color.green);
        panel10.setBackground(Color.yellow);

        panel5.add(panel6, BorderLayout.NORTH);
        panel5.add(panel7, BorderLayout.EAST);
        //panel5.add(panel8,BorderLayout.WEST);
        panel5.add(panel9, BorderLayout.SOUTH);
        panel5.add(panel10, BorderLayout.CENTER);


        QuestionImage = new JLabel();
        panel10.add(QuestionImage);

        singlePlayer = new JButton("Ένας Παίχτης");
        singlePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playersInfo = new JLabel[1];
                playerName("Player1");
                updatePlayers(panel1);
                clearChoices(panel4);
                try {
                    newGameSingle();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        twoPlayers = new JButton("Δύο Παίχτες");
        twoPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playersInfo = new JLabel[2];
                playerName("Player1");
                playerName("Player2");
                updatePlayers(panel1);
                clearChoices(panel4);
                try {
                    newGame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        panel4.setLayout(new GridLayout(0, 2));
        panel4.add(singlePlayer);
        panel4.add(twoPlayers);

        TypeOfRound = new JLabel();
        panel6.add(TypeOfRound);
        QuestionCategory = new JLabel();
        QuestionTitle = new JLabel();
        Answer1 = new JLabel();
        Answer2 = new JLabel();
        Answer3 = new JLabel();
        Answer4= new JLabel();
        CorrectAnswer = new JLabel();
        timerLabel = new JLabel();
        panel7.add(timerLabel);


        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                switch (e.getKeyChar()){
                    case 'q':
                        try {
                            letterGiven('q');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 'w':
                        try {
                            letterGiven('w');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 'e':
                        try {
                            letterGiven('e');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 'r':
                        try {
                            letterGiven('r');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 'u':
                        try {
                            letterGiven('u');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 'i':
                        try {
                            letterGiven('i');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 'o':
                        try {
                            letterGiven('o');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 'p':
                        try {
                            letterGiven('p');
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                }
            }
        });

    }   //End of GUI Constructor


    /**
     * Function that clears the main frame
     */
    public void clearCentral(){
        TypeOfRound.setText("");
        QuestionCategory.setText("");
        Answer1.setText("");
        Answer2.setText("");
        Answer3.setText("");
        Answer4.setText("");
        timerLabel.setText("");
    }

    /**
     * Remove all elements in a JPanel and repaints it
     * @param panel: The panel that we want to clear and revalidate
     * @author Nikitas
     */
    public void clearChoices(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    /**
     * Set the frame that the game will be played visible.
     * @autgor Nikitas
     */
    public void start() {
        frame.setVisible(true);
    }

    /**
     * Creates a JDialog that has a JTextField and a JButton.
     * Once the player types his name, he must click the button to continue
     * and the program keep his info.
     * @param player : A string to be shown as we asking for player's name.
     * @author Stavros
     */
    public void playerName(String player) {
        JDialog nameDialog = new JDialog(frame, true);
        //nameDialog.setModalityType( Dialog.ModalityType.APPLICATION_MODAL);
        nameDialog.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel name = new JLabel(player + " name:");
        JTextField namePlayer = new JTextField(15);
        JButton submit = new JButton("Submit");
        nameDialog.add(name);
        nameDialog.add(namePlayer);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!namePlayer.getText().equals("")) {
                    logic.addPlayer(namePlayer.getText());
                    nameDialog.dispose();
                }
            }
        });
        nameDialog.add(submit);
        nameDialog.setTitle("Hello " + player);
        nameDialog.setSize(300, 100);
        nameDialog.setLocationRelativeTo(null);
        nameDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        nameDialog.setVisible(true);
        nameDialog.pack();

    }

    /**
     * We take from the logic the players info and creates the corresponding
     * JLabels. After that we update the topPanel
     * @param panel The panel where we want to keep the JLabels of each player
     * @author Stavros
     */
    public void updatePlayers(JPanel panel) {
        int i = 0;
        for (Player p : logic.getPlayers()) {
            String name = p.getName();
            double points = p.getPoints();
            playersInfo[i] = new JLabel(name + ": " + String.valueOf(points) + " points          ");
            playersInfo[i].setFont(new Font("Calibri", Font.PLAIN, 20));
            panel.add(playersInfo[i]);
            i++;
        }
        updateTopPanel(panel);
    }

    /**
     * Updating the panel where players' info are displaying.
     * @param panel The panel where the update will take place
     * @author Stavros
     */
    public void updateTopPanel(JPanel panel) {

        int i = 0;
        for (Player p : logic.getPlayers()) {
            String name = p.getName();
            double points = p.getPoints();
            playersInfo[i].setText(name + ": " + String.valueOf(points) + " points          ");
            playersInfo[i].setFont(new Font("Calibri", Font.PLAIN, 20));

            i++;
        }
        panel.revalidate();
        panel.repaint();
    }

    /**
     *  Create a JDialog for the player to pick the number of rounds
     *  that wants to play. If he pushes the JButton and the number
     *  is valid the info are sending to the logic.
     * @author Nikitas
     */
    public void roundSubmit() {
        JDialog roundDialog = new JDialog(frame, true);
        roundDialog.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel rounds = new JLabel("Number of rounds:");
        JTextField roundsField = new JTextField(3);
        JButton submit = new JButton("Submit");
        roundDialog.add(rounds);
        roundDialog.add(roundsField);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!roundsField.getText().equals("")) {
                    if (logic.checkSufficient(Integer.parseInt(roundsField.getText()))) {
                        logic.setRound(Integer.parseInt(roundsField.getText()));
                        roundDialog.dispose();
                    } else {
                        rounds.setText(logic.maximumRounds());
                    }
                }
            }
        });
        roundDialog.add(submit);
        roundDialog.setTitle("Choose round");
        roundDialog.setSize(300, 100);
        roundDialog.setLocationRelativeTo(null);
        roundDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        roundDialog.setVisible(true);
        roundDialog.pack();
    }


    /**
     * Prints all the useful info each time for the question or anything else.
     * @author Nikitas
     */
    private void printLabels (){
        int roundType = logic.getCurrentRoundType();
        if( roundType == 1){
            if(!logic.checkBetPlayers()){
                ArrayList<String> questionInfo = logic.getQuestionInfo();
                TypeOfRound.setText(logic.intToRoundType(1));
                TypeOfRound.setFont(new Font("Serif", Font.BOLD,30));
                QuestionCategory.setText(questionInfo.get(0));
                QuestionCategory.setFont(new Font("Serif", Font.BOLD,25));
                QuestionTitle.setText("Place your bets to continue after checking the category below!");
                QuestionTitle.setFont(new Font("Serif",Font.PLAIN,20));
                Answer1.setText("1)  "+ Integer.toString(logic.getBetRound().getBet1()));
                Answer2.setText("2)  "+ Integer.toString(logic.getBetRound().getBet2()));
                Answer3.setText("3)  "+ Integer.toString(logic.getBetRound().getBet3()));
                Answer4.setText("4)  "+ Integer.toString(logic.getBetRound().getBet4()));
                Answer1.setFont(new Font("Serif",Font.PLAIN,20));
                Answer2.setFont(new Font("Serif",Font.PLAIN,20));
                Answer3.setFont(new Font("Serif",Font.PLAIN,20));
                Answer4.setFont(new Font("Serif",Font.PLAIN,20));

                panel9.add(QuestionCategory);
                panel10.add(QuestionTitle);
                panel4.setLayout(new GridLayout(0,2));
                panel4.add(Answer1);
                panel4.add(Answer2);
                panel4.add(Answer3);
                panel4.add(Answer4);

                return;
            }

        }

            ArrayList<String> questionInfo = logic.getQuestionInfo();
            TypeOfRound.setText(logic.intToRoundType(logic.getCurrentRoundType()));
            TypeOfRound.setFont(new Font("Serif", Font.BOLD,30));
            QuestionCategory.setText(questionInfo.get(0));
            QuestionCategory.setFont(new Font("Serif", Font.BOLD,25));
            QuestionTitle.setText(questionInfo.get(1));
            QuestionTitle.setFont(new Font("Serif",Font.PLAIN,19));
            Answer1.setText("1)  " + questionInfo.get(2));
            Answer2.setText("2)  " + questionInfo.get(3));
            Answer3.setText("3)  " + questionInfo.get(4));
            Answer4.setText("4)  " + questionInfo.get(5));
            Answer1.setFont(new Font("Serif",Font.PLAIN,20));
            Answer2.setFont(new Font("Serif",Font.PLAIN,20));
            Answer3.setFont(new Font("Serif",Font.PLAIN,20));
            Answer4.setFont(new Font("Serif",Font.PLAIN,20));
            if (questionInfo.size() == 7) {
                //QuestionImage = new JLabel();
                QuestionImage.setIcon(new ImageIcon(Resource.getURL(questionInfo.get(6))));
                //panel5.add(QuestionImage);
                System.out.println("Hrtha" + questionInfo.get(6));
            }

        panel9.add(QuestionCategory);
        panel10.add(QuestionTitle);
        panel4.setLayout(new GridLayout(0,2));
        panel4.add(Answer1);
        panel4.add(Answer2);
        panel4.add(Answer3);
        panel4.add(Answer4);

    }

    /**
     * Initializes the game for a single player.
     * @author Stavros
     */
    private void newGameSingle() throws IOException {
        start(); // Something
        roundSubmit(); //How many rounds will be played -> Saved in BuzzLogic.variable-rounds
        logic.currentQuestions(logic.getRound()); // Initializing the Question array
        do {
            logic.setCurrentRoundType();// Setting which round will be played first
        }while ((logic.getCurrentRoundType() == 2) || (logic.getCurrentRoundType() == 4)  );
        if(logic.getCurrentRoundType()==3)
        {
            logic.getStopTimerRound().countDownTimer(5000, logic.getPlayers(), timerLabel);
        }
        logic.chooseQuestion(); // Question initializer
        logic.makeNullAnswers();
        updateFrame();

    }

    /**
     * Initializes the game for 2 players.
     * @author Nikitas
     */
    private void newGame() throws IOException {
        start(); // Something
        roundSubmit(); //How many rounds will be played -> Saved in BuzzLogic.variable-rounds
        logic.currentQuestions(logic.getRound()); // Initializing the Question array
        logic.setCurrentRoundType(); // Setting which round will be played first
        if(logic.getCurrentRoundType()==3)
        {
            logic.getStopTimerRound().countDownTimer(5000, logic.getPlayers(), timerLabel);
        }
        logic.chooseQuestion(); // Question initializer
        logic.makeNullAnswers();
        updateFrame();
    }

    /**
     * Given the typed button from the keyboard and based
     * with the current round type the appropriate handler
     * will be called
     * @param c The char that has been typed from a player
     * @author Nikitas
     */
    private void letterGiven( char c) throws IOException {
        int roundType = logic.getCurrentRoundType();
        if(  (roundType == 0) || ( roundType == 4 )){
            correctAnswerHandler(c);
        }
        else if( roundType == 1){
            betAnswerHandler(c);
        }
        else if( roundType == 2){
            fastAnswerHandler(c);
        }
        else if( roundType == 3 ){
            stopTimerHandler(c);
        }
        updateFrame();
    }

    /**
     * Handler of stopTimer
     * @param c : The button that has been pushed.
     * @author Stavros
     */
    public void stopTimerHandler( char c ){
        switch( c ){
            case 'q':
                checkStopTimerAndSetText(0 , 1);
                break;
            case 'w':
                checkStopTimerAndSetText(0 , 2);
                break;
            case 'e':
                checkStopTimerAndSetText(0 , 3);
                break;
            case 'r':
                checkStopTimerAndSetText(0 , 4);
                break;
            case 'u':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,1);
                break;
            case 'i':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,2);
                break;
            case 'o':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,3);
                break;
            case 'p':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,4);
                break;
        }
    }

    /**
     * Sets the appropriate info for the player and stopTimer round
     * @param playerId Player's id
     * @param answer Player's answer
     * @author Stavros
     */
    public void checkStopTimerAndSetText(int playerId , int answer){
        switch(answer){
            case 1:
                if(!logic.checkNullPlayerAnswer(playerId)){
                    logic.setPlayerAnswer(playerId, Answer1.getText().substring(4));
                    String time = timerLabel.getText();
                    int newTime = Integer.parseInt(time);
                    logic.setPlayerTimerRemaining(playerId,newTime);
                }
                break;
            case 2:
                if(!logic.checkNullPlayerAnswer(playerId)){
                    logic.setPlayerAnswer(playerId, Answer2.getText().substring(4));
                    String time = timerLabel.getText();
                    int newTime = Integer.parseInt(time);
                    logic.setPlayerTimerRemaining(playerId,newTime);
                }
                break;
            case 3:
                if(!logic.checkNullPlayerAnswer(playerId)){
                    logic.setPlayerAnswer(playerId, Answer3.getText().substring(4));
                    String time = timerLabel.getText();
                    int newTime = Integer.parseInt(time);
                    logic.setPlayerTimerRemaining(playerId,newTime);
                }
                break;
            case 4:
                if(!logic.checkNullPlayerAnswer(playerId)){
                    logic.setPlayerAnswer(playerId, Answer4.getText().substring(4));
                    String time = timerLabel.getText();
                    int newTime = Integer.parseInt(time);
                    logic.setPlayerTimerRemaining(playerId,newTime);
                }
                break;
        }
    }

    /**
     * Handler of FastAnswer
     * @param c : The button that has been pushed.
     * @author Nikitas
     */
    public void fastAnswerHandler( char c){
        switch ( c ){
            case 'q':
                checkFastAnswerAndSetText(0,1);
                break;
            case 'w':
                checkFastAnswerAndSetText(0,2);
                break;
            case 'e':
                checkFastAnswerAndSetText(0,3);
                break;
            case 'r':
                checkFastAnswerAndSetText(0,4);
                break;
            case 'u':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,1);
                break;
            case 'i':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,2);
                break;
            case 'o':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,3);
                break;
            case 'p':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkFastAnswerAndSetText(1,4);
                break;
        }
    }

    /**
     * Sets the appropriate info for the player and fastAnswer round
     * @param playerId Player's id
     * @param answer Player's answer
     * @author Nikitas
     */
    void checkFastAnswerAndSetText(int playerId , int answer){
        switch( answer ){
            case 1:
                if( (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerFastAnswer(playerId, Answer1.getText().substring(4));
                }
                break;
            case 2:
                if( (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerFastAnswer(playerId, Answer2.getText().substring(4));
                }
                break;
            case 3:
                if( (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerFastAnswer(playerId, Answer3.getText().substring(4));
                }
                break;
            case 4:
                if( (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerFastAnswer(playerId, Answer4.getText().substring(4));
                }
                break;
        }
    }


    /**
     * Handler of BetRound
     * @param c : The button that has been pushed.
     * @author Nikitas
     */
    public void betAnswerHandler(char c) {
        switch ( c ) {
            case 'q':
                checkBetAnswerAndSetText(0,1);
                break;
            case 'w':
                checkBetAnswerAndSetText(0,2);
                break;
            case 'e':
                checkBetAnswerAndSetText(0,3);
                break;
            case 'r':
                checkBetAnswerAndSetText(0,4);
                break;
            case 'u':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkBetAnswerAndSetText(1,1);
                break;
            case 'i':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkBetAnswerAndSetText(1,2);
                break;
            case 'o':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkBetAnswerAndSetText(1,3);
                break;
            case 'p':
                if(logic.getPlayers().size() == 1){
                    return;
                }
                checkBetAnswerAndSetText(1,4);
                break;

      }
    }

    /**
     * Sets the appropriate info for the player and BetRound
     * @param playerId Player's id
     * @param answerId Player's answer
     * @author Nikitas
     */
    public void checkBetAnswerAndSetText(int playerId, int answerId) {
        switch ( answerId) {
            case 1:
                if((logic.checkBetPlayers()) && (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerAnswer(playerId, Answer1.getText().substring(4));
                }
                else if (!logic.checkBetPlayerAnswer(playerId)){
                    logic.setPlayerBet(playerId,Integer.parseInt(Answer1.getText().substring(4)));
                }
                break;
            case 2:
                if((logic.checkBetPlayers()) && (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerAnswer(playerId, Answer2.getText().substring(4));
                }
                else if (!logic.checkBetPlayerAnswer(playerId)){
                    logic.setPlayerBet(playerId,Integer.parseInt(Answer2.getText().substring(4)));
                }
                break;
            case 3:
                if((logic.checkBetPlayers()) && (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerAnswer(playerId, Answer3.getText().substring(4));
                }
                else if (!logic.checkBetPlayerAnswer(playerId)){
                    logic.setPlayerBet(playerId,Integer.parseInt(Answer3.getText().substring(4)));
                }
                break;
            case 4:
                if((logic.checkBetPlayers()) && (!logic.checkNullPlayerAnswer(playerId))){
                    logic.setPlayerAnswer(playerId, Answer4.getText().substring(4));
                }
                else if (!logic.checkBetPlayerAnswer(playerId)){
                    logic.setPlayerBet(playerId,Integer.parseInt(Answer4.getText().substring(4)));
                }
                break;
        }
    }

    /**
     * Handler of correctAnswer
     * @param c : The button that has been pushed.
     * @author Nikitas-Stavros
     */
    public void correctAnswerHandler(char c){
        switch( c ){
            case 'q':
                checkNullAndSetText( 0, 1);
                break;
            case 'w':
                checkNullAndSetText( 0, 2);
                break;
            case 'e':
                checkNullAndSetText( 0, 3);
                break;
            case 'r':
                checkNullAndSetText( 0, 4);
                break;
            case 'u':
                if(logic.getPlayers().size() == 1)
                    return;
                checkNullAndSetText( 1, 1);
                break;
            case 'i':
                if(logic.getPlayers().size() == 1)
                    return;
                checkNullAndSetText( 1, 2);
                break;
            case 'o':
                if(logic.getPlayers().size() == 1)
                    return;
                checkNullAndSetText( 1, 3);
                break;
            case 'p':
                if(logic.getPlayers().size() == 1)
                    return;
                checkNullAndSetText( 1, 4);
                break;
                }

        }

    /**
     * Sets the appropriate info for the player and BetRound
     * @param playerId Player's id
     * @param answerId Player's answer
     * @author Nikitas-Stavros
     */
    public void checkNullAndSetText(int playerId, int answerId){
        if(!(logic.checkNullPlayerAnswer(playerId))){
            switch ( answerId ){
                case 1:
                    logic.setPlayerAnswer(playerId ,Answer1.getText().substring(4) );
                    break;
                case 2:
                    logic.setPlayerAnswer(playerId ,Answer2.getText().substring(4) );
                    break;
                case 3:
                    logic.setPlayerAnswer(playerId ,Answer3.getText().substring(4) );
                    break;
                case 4:
                    logic.setPlayerAnswer(playerId ,Answer4.getText().substring(4) );
                    break;
            }
        }
    }

    /**
     * Checking the status of the game and updates it properly.
     * @author Nikitas-Stavros
     */
    private void updateFrame() throws IOException {
        System.out.println( numberOfQuestionsRound );
        System.out.println( logic.getCounterQuestions() );
        if(logic.getCurrentRoundType() != 3){
            timerLabel.setText(null);
        }

        if(timerLabel.getText() == "Time out!"){
            QuestionImage.setIcon(null);
            logic.setTimedOutAnswer();
        }

        if( logic.checkNullAnswer() ) {
            if (logic.getCurrentRoundType() == 0)
                logic.getCorrectAnswerRound().checkPlayerAnswers(logic.getPlayers(), logic.getCurrentQuestion());
            else if (logic.getCurrentRoundType() == 1)
                logic.getBetRound().checkPlayerAnswers(logic.getPlayers(), logic.getCurrentQuestion());
            else if (logic.getCurrentRoundType() == 2)
                logic.getFastAnswerRound().checkPlayerAnswers(logic.getPlayers(), logic.getCurrentQuestion());
            else if (logic.getCurrentRoundType() == 3) {
                //logic.getStopTimerRound().countDownTimer(5000, logic.getPlayers(), timerLabel);
                logic.getStopTimerRound().checkPlayerAnswers(logic.getPlayers(), logic.getCurrentQuestion());
            }
            else if (logic.getCurrentRoundType() == 4)
                logic.getThermometerRound().checkPlayerAnswers(logic.getPlayers(), logic.getCurrentQuestion());


            logic.makeNullAnswers();
            logic.makeBetNull();
            logic.makeFalseFirst();
            logic.removeQuestion(logic.getCurrentQuestionId());
            QuestionImage.setIcon(null);
            logic.chooseQuestion();
            if (logic.getCurrentRoundType() == 3) {
                logic.getStopTimerRound().countDownTimer(5000, logic.getPlayers(), timerLabel);
            }
        }

        if(logic.getCounterQuestions() % (numberOfQuestionsRound + 1) == 0){
            if(logic.getPlayers().size() == 1){
                do {
                    logic.setCurrentRoundType();// Setting which round will be played first
                }while ((logic.getCurrentRoundType() == 2) || (logic.getCurrentRoundType() == 4)  );
                if (logic.getCurrentRoundType() == 3) {
                    logic.getStopTimerRound().countDownTimer(5000, logic.getPlayers(), timerLabel);
                }
            }
            else{
                logic.setCurrentRoundType();
                if (logic.getCurrentRoundType() == 3) {
                    logic.getStopTimerRound().countDownTimer(5000, logic.getPlayers(), timerLabel);
                }
            }
            logic.makeZeroWinSeq();
            numberOfQuestionsRound += 5;
        }

        if(logic.getCounterQuestions() == logic.getRound() * 5 + 1){
            System.out.println("This is the end you know " + logic.getCounterQuestions() +' '+logic.getCurrentQuestionsArray().size());
            //player1 = logic.getPlayers().get(0).getName();
            //player2 = logic.getPlayers().get(1).getName();
            //points1 = logic.getPlayers().get(0).getPoints();
            //points2 = logic.getPlayers().get(1).getPoints();

            //logic.getSavedata().updateSave(player1,player2,points1,points2);
            //logic.getSavedata().checkSaveData(player1,points1);
            //logic.getSavedata().checkSaveData(player2,points2);
            logic.Savedatatxt(logic.getPlayers());
            System.out.println("Data Saved");
            frame.dispose();
        }


            printLabels();
            updateTopPanel(panel1);
        System.out.println( numberOfQuestionsRound );
        System.out.println( logic.getCounterQuestions() );

    }

    }

