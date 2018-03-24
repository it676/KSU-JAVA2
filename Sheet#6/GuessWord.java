
import java.util.Scanner;

/**
 *
 * @author IT676
 */
public class GuessWord {

    private final static String[] dictionary
            = {
                "purple", "animal", "house",
                "book", "cat", "computer",
                "school", "teacher", "party",
                "dress", "earth", "apple",
                "university", "flower", "cookies"
            };

    private Player p;
    private int gameW;
    private String guessedW;
    private int hNo;
    private int gNo;
    private double score;

    public GuessWord() {

        gameW = -1;

    }

    public void connectPlayer(Player p) {

        this.p = p;

    }

    public void generateWord() {

        int min = 0, max = 14;

        int randomIndex = min + (int) (Math.random() * (max - min + 1));
        gameW = randomIndex;

        String randomlySelectedWord = dictionary[gameW];//you can skip this var , by replacing .length in for loop directly

        guessedW = "";//set it to "" for reset for the next call of the method
        for (int i = 0; i < randomlySelectedWord.length(); i++) {
            guessedW += "-";
        }

    }//end of generateWord()

    public void generateWord(int index) {

        Scanner input = new Scanner(System.in);
        boolean tryAgain = true;

        while (tryAgain) {
            try {

                gameW = index;

                guessedW = "";//set it to "" for reset for the next call of the method

                for (int i = 0; i < dictionary[gameW].length(); i++) {
                    guessedW += "-";
                }

                tryAgain = false;

            } catch (ArrayIndexOutOfBoundsException ex) {

                System.err.println("Error: there is no word available in the given index. Try again");
                index = input.nextInt();//try to enter the index again 
                /**
                 * you can write another try-catch statement for the
                 * InputMismatchException here to handle InputMismatchException
                 * in case user entered an invalid integer
                 */

            }
        }

    }//end of generateWord(int index)

    public void generateRecord() {

        String record = p.getName() + "-" + guessedW + "-" + score;
        p.addRecord(record);
    }//end of generateRecord()

    public void updateScore() {

        score = 5 * (7 - hNo - (0.5 * gNo)) / 7;
    }//end of updateScore()

    public boolean isLoser() {

        if (!guessedW.equals(dictionary[gameW])) {
            if (gNo == 3) {

                return true;

            }
        }

        return false;
    }//end of isLoser()

    public boolean isWinner() {

        return (guessedW.equals(dictionary[gameW]));

    }//end of isWinner()

    public void hint() throws NumberExceededException {

        //if user consumed his/her hints , then throw an exception 
        if (hNo == 3) {

            throw new NumberExceededException("Error: sorry, you consumed all the available hints");
        }

        //find the index of the first unguessed letter startig from first position in the string
        int indexOfUnguessedLetter = guessedW.indexOf('-', 0);

        //get the actual letter for the char at that index 
        char letter = dictionary[gameW].charAt(indexOfUnguessedLetter);

        //convert your string to an array of chars to make it easier to replace any char at any index
        //or you can use StringBuilder class with setCharAt(index , char) method.
        //I.e : guessedW.setCharAt(3, 'P') 
        char[] guessedWordLetters = guessedW.toCharArray();

        //loop through the array(or dictionary[gameW] string) to replace all occurrences of the letter
        for (int i = 0; i < guessedWordLetters.length; i++) {

            //if char matched then repleace it
            if (dictionary[gameW].charAt(i) == letter) {
                guessedWordLetters[i] = letter;

            }
        }//end of for

        //take the string back from the char array
        guessedW = String.copyValueOf(guessedWordLetters);

        //remove the array by setting it to null --> optional
        guessedWordLetters = null;

        //update hints counter for the player
        hNo++;

    }//end of hint()

    public boolean guess(char ch) {

        //check if the char is there or not 
        int index = dictionary[gameW].indexOf(ch);

        //if letter is not in the genrated word 
        if (index == -1) {

            //update incorrect guessing attempts for the player and return false
            gNo++;

            return false;

        } //if letter is there , so replace it and all its occurrences in the guessedW string
        else {

            char[] guessedWordLetters = guessedW.toCharArray();

            //loop through the array(or dictionary[gameW] string) to replace all occurrences of the letter
            for (int i = 0; i < guessedWordLetters.length; i++) {

                //if char matched then repleace it
                if (dictionary[gameW].charAt(i) == ch) {
                    guessedWordLetters[i] = ch;

                }
            }//end of for

            guessedW = String.copyValueOf(guessedWordLetters);
            return true;
        }
    }//end of guess(char ch)

    public void reset() {

        gameW = 0;
        guessedW = "";
        hNo = 0;
        gNo = 0;
        score = 0;

    }//end of reset()

    public void displayRecords() {

        String[] playerRecords = p.getRecords();
        for (int i = 0; i < p.getNumberOfRecords(); i++) {

            String fullRecord = playerRecords[i];

            int indexOfFirstDash = fullRecord.indexOf("-");
            int indexOfSecondDash = fullRecord.indexOf("-", indexOfFirstDash + 1);
            String name = fullRecord.substring(0, indexOfFirstDash);
            String word = fullRecord.substring(indexOfFirstDash + 1, indexOfSecondDash);
            String scoreStr = fullRecord.substring(indexOfSecondDash + 1);

            //you may handle NumberFormatException , but
            //not necessary since you as programmer who wrote the code of score in the string 
            //so we know that the score always is a valid number.
            double playerScore = Double.parseDouble(scoreStr);

            System.out.printf("Name: %s, Word: %s, Score: %.4f%n", name, word, playerScore);
        }
    }//end of displayRecords()

    public String getGuessedW() {

        return guessedW;
    }

    public String getGameWord() {

        return dictionary[gameW];
    }

}
