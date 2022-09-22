// Imports
import java.awt.*;
import javax.swing.*;

// SouthPanel Class
public class SouthPanel extends JPanel {
    // Instance Variables
    public JLabel wordLabel;
    public JLabel guessLabel;
    public JLabel lettersLabel;
    public JButton newButton;

    // Default Constructor
    public SouthPanel() {
        // SouthPanel Initialization
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // wordLabel Initialization
        wordLabel = new JLabel("<word>");
        wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // guessLabel Initialization
        guessLabel = new JLabel("You have <number> guesses left.");
        guessLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // lettersLabel Initialization
        lettersLabel = new JLabel(" a b c d e f g h i j k l m n o p q r s t u v w x y z ");
        lettersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // newButton Initialization
        newButton = new JButton("New");
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // SouthPanel Configurations
        this.add(wordLabel);
        this.add(guessLabel);
        this.add(lettersLabel);
        this.add(newButton);

        // SouthPanel Finished
        System.out.println("SouthPanel.java Initialized");
    }
    
}