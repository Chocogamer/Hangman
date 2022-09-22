// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Game Class
public class Game {
    // Instance Variables
    public String currentWord;
    public String displayString;
    public int guessCount;
    public String[] wordLetters;
    public String alphabet;

    // Default Constructor
    public Game() {
        newWord();
        System.out.println("Word is: " + currentWord);

        displayString = "";
        for(int i = 0; i < currentWord.length(); i++) {
            displayString += "_";
        }

        guessCount = (int)(currentWord.length() * 1.5);

        wordLetters = new String[currentWord.length()];
        for(int i = 0; i < currentWord.length(); i++) {
            wordLetters[i] = currentWord.substring(i, i+1);
        }

        alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";

        System.out.println("Game.java Initialized");
    }

    public void newWord() {

        try {
            // initializing file and scanner
            Scanner scanner = new Scanner(new File("words.txt"));

            // finding total number of lines in file
            int totalLines = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                totalLines++;
            }

            // random line
            int random = (int)(Math.random()*totalLines);
            int count = 0;
            // reset scanner
            scanner = new Scanner(new File("words.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(count == random) {
                    currentWord = line;
                    break;
                }
                count++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }

    }

    public void reset() {
        newWord();
        System.out.println("Word is: " + currentWord);

        displayString = "";
        for(int i = 0; i < currentWord.length(); i++) {
            displayString += "_ ";
        }

        guessCount = (int)(currentWord.length() * 1.5);

        wordLetters = new String[currentWord.length()];
        for(int i = 0; i < currentWord.length(); i++) {
            wordLetters[i] = currentWord.substring(i, i+1);
        }

        alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
    }

}