package Buzz;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class HandleKeys {

    public HandleKeys( JFrame frame, Player aPlayer,JLabel Answer1,JLabel Answer2, JLabel Answer3, JLabel Answer4,char choice1, char choice2, char choice3, char choice4, int[] flags) {

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if(  (e.getKeyChar() == choice1) && ( flags[0] == 0 ) ){
                    aPlayer.setCurrentAnswer( Answer1.getText().substring(4,Answer1.getText().length() - 1));
                    //frame.removeKeyListener( this);
                    flags[0] = 1;
                }
                else if((e.getKeyChar() == choice2) && ( flags[0] == 0 ) ){
                    aPlayer.setCurrentAnswer( Answer2.getText().substring(4,Answer2.getText().length() - 1));
                    //frame.removeKeyListener( this);
                    flags[0] = 1;
                }
                else if((e.getKeyChar() == choice3) && ( flags[0] == 0 ) ){
                    aPlayer.setCurrentAnswer( Answer3.getText().substring(4,Answer3.getText().length() - 1));
                    //frame.removeKeyListener( this);
                    flags[0] = 1;
                }
                else if((e.getKeyChar() == choice4) && ( flags[0] == 0 ) ){
                    //System.out.println("Player 1 - Answer D");
                    aPlayer.setCurrentAnswer( Answer4.getText().substring(4,Answer4.getText().length() - 1));
                    //frame.removeKeyListener( this);
                    flags[0] = 1;

                }
            }
        });
    }
}