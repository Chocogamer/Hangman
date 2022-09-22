// Imports
import java.awt.*;
import javax.swing.*;

// HangmanPanel Class
public class HangmanPanel extends JPanel {
    //Instance Variables
    private Game game;

    // Default Constructor
    public HangmanPanel(Game game) {
        this.game = game;

        // HangmanPanel Finished
        System.out.println("HangmanPanel.java Initialized");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        // Pole Base
        g.drawLine( (this.getWidth()/2), (this.getHeight()*10/100), (this.getWidth()/2), (this.getHeight()/2) );
        // Pole Hang
        g.drawLine( (this.getWidth()/2), (this.getHeight()*10/100), (this.getWidth()*30/100), (this.getHeight()*10/100) );
        // Pole Leg Left
        g.drawLine( (this.getWidth()/2), (this.getHeight()/2), (this.getWidth()*60/100), (this.getHeight()*60/100) );
        // Pole Leg Right
        g.drawLine( (this.getWidth()/2), (this.getHeight()/2), (this.getWidth()*40/100), (this.getHeight()*60/100) );

        int c = game.guessCount;
        if(c <= 6) {
            // Person Head
            g.drawOval( (this.getWidth()*30/100), (this.getHeight()/2 - this.getHeight()*40/100), 50, 50 );
            if(c <= 5) {
                // Person Torso
                g.drawLine( (this.getWidth()*30/100) + 25, (this.getHeight()*10/100) + 50, (this.getWidth()*30/100) + 25,  (this.getHeight()*40/100) );
                if(c <= 4) {
                    // Person Arm Left
                    g.drawLine( (this.getWidth()*30/100) + 25, (this.getHeight()*30/100), (this.getWidth()*25/100), (this.getHeight()*25/100));
                    if(c <= 3) {
                        // Person Arm Right
                        g.drawLine( (this.getWidth()*30/100) + 25, (this.getHeight()*30/100), (this.getWidth()*45/100), (this.getHeight()*25/100));
                        if(c <= 2) {
                            // Person Leg Left
                            g.drawLine( (this.getWidth()*30/100) + 25, (this.getHeight()*40/100), (this.getWidth()*25/100), (this.getHeight()*50/100) );
                            if(c <= 1) {
                                // Person Leg Right
                                g.drawLine( (this.getWidth()*30/100) + 25, (this.getHeight()*40/100), (this.getWidth()*45/100), (this.getHeight()*50/100) );
                            }
                        }
                    }
                }
            }
        }
    }
}