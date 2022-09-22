// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    // Instance Variable Declaration
    private Game game;
    private JFrame frame;
    private HangmanPanel hangmanPanel;
    private SouthPanel southPanel;

    // Default Constructor
    public GUI() {
        // word Initialization
        game = new Game(); 
        System.out.println("Word is: " + game.currentWord);

        // frame Initialization
        frame = new JFrame("Hangman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // hangmanPanel Initialization
        hangmanPanel = new HangmanPanel(game);

        // southPanel Initialization
        southPanel = new SouthPanel();
        southPanel.wordLabel.setText(game.displayString);
        southPanel.guessLabel.setText("You have " + game.guessCount + " guesses left!");
        southPanel.lettersLabel.setText(game.alphabet);
        southPanel.newButton.addActionListener(new MyActionListener());

        // frame Configurations
        frame.add(hangmanPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.addKeyListener(new MyKeyListener());
        frame.setFocusable(true);
        frame.setVisible(true);

        // GUI Finished
        System.out.println("GUI.java Initialized");
    }

    public class MyKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode())); 
            boolean win = game.displayString.equals(game.currentWord);
            if(win) {
                southPanel.guessLabel.setText("Congratulations! You won with " + game.guessCount + " guesses left!");
            } else if( (game.guessCount >= 1) && !(win) ) {

                String lett = KeyEvent.getKeyText(e.getKeyCode()).toLowerCase();
                game.alphabet = game.alphabet.replace(lett, " ");
                for(int i = 0; i < game.wordLetters.length; i++) {
                    if(lett.equals(game.wordLetters[i])) {
                        game.displayString = game.displayString.substring(0, i) + lett + game.displayString.substring(i+1);
                    } 
                }
                if(!(game.currentWord.contains(lett))) {
                    game.guessCount--;
                }
                
                southPanel.wordLabel.setText(game.displayString);
                southPanel.guessLabel.setText("You have " + game.guessCount + " guesses left!");
                southPanel.lettersLabel.setText(game.alphabet);

            } else {
                southPanel.guessLabel.setText("You lost! :(");
            }
            hangmanPanel.repaint();

        }

        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(event.getSource().equals(southPanel.newButton)) {
                game.reset();
                southPanel.wordLabel.setText(game.displayString);
                southPanel.guessLabel.setText("You have " + game.guessCount + " guesses left!");
                southPanel.lettersLabel.setText(game.alphabet);
                southPanel.newButton.setFocusable(false);
            }
        }
    }

}