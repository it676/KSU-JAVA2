
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    static GuessWord gw;
    static String tab1 = "   ";
    static String tab2 = "     ";
    static String tab3 = "       ";
    static Scanner reader = new Scanner(System.in);

    /**
     * The main method of the program that reads player's information, connect
     * it to the game, generates the word, and starts the playing.
     *
     * @param args
     */
    public static void main(String[] args) {
        String n = "";
        char c = '\u0000';
        gw = new GuessWord();

        System.out.println("**** Welcome to Guess Word game ****\n");

        // Read a player name
        System.out.print(tab1 + "-> Enter your name: ");
        n = reader.next();

        // Connect the player to the game
        gw.connectPlayer(new Player(n));

        // Play until the player wants to exit
        do {
            // Generate the game word either randomly (the default) or by player's choice
            System.out.print(tab1 + "-> Do you want to choose a specific word (Y | N)? ");
            c = reader.next().charAt(0);
            if (Character.toUpperCase(c) == 'Y') {
                System.out.print(tab2 + "-> Enter the index of the word that you want to choose: ");
                gw.generateWord(reader.nextInt());
            } else {
                gw.generateWord();
            }
            System.out.println(tab1 + " A word is generated: " + gw.getGuessedW());

            play();
            System.out.print(tab1 + "-> Do you want to play again (Y | N)? ");
            c = reader.next().charAt(0);
            gw.reset();
        } while (Character.toUpperCase(c) == 'Y');

        System.out.println(tab1 + " Your last three score records are: ");

        // Display the last three records of the player
        gw.displayRecords();
        System.out.println("\n**** We hope you have enjoyed it, see you ;) ****");
    }

    /**
     * Called by the main, the engine of the game that consciously reads
     * player's guesses and calls GuessWord methods.
     */
    public static void play() {
        Scanner reader = new Scanner(System.in);
        char ch;

        // Play while the game is not over; it is over if the player won or lost the
        // game
        while (!gw.isWinner() && !gw.isLoser()) {

            // Read a letter (as a guess) or ? for a hint
            System.out.print(tab2 + "-> Guess a letter or enter ? for a hint: ");
            ch = reader.next().charAt(0);

            // Check if the entered character is a letter
            if (Character.isLetter(ch)) {

                // Call guess method
                if (gw.guess(Character.toLowerCase(ch))) {
                    System.out.println(tab3 + " Correct Guess :) The word is: " + gw.getGuessedW());
                } else {
                    System.out.println(tab3 + " Incorrect Guess :( The word is: " + gw.getGuessedW());
                }
            } // Check if the entered character is a ?
            else if (ch == '?') // Call hint method
            {
                try {
                    gw.hint();
                    System.out.println(tab3 + " The word is: " + gw.getGuessedW());
                } catch (NumberExceededException ex) {
                    //display the exception message 
                    System.out.println(ex.getMessage());
                }
            }
        }

        // Check if the player won or lost the game
        if (gw.isLoser()) {
            System.out.println("\n" + tab1 + " You lost :( The word is: " + gw.getGameWord() + "\n");
        } else {
            System.out.println("\n" + tab1 + " You won :)\n");

            // Update player score
            gw.updateScore();
            // Generate the player game record
            gw.generateRecord();
        }
    }
}
