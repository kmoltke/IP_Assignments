import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Kristian Moltke Reitzel
 * 
 * Class lets you enter swear words separated by space to be filtered
 * on input line 1
 * 
 * The lines after contains the tweet to filter out swear words.
 * 
 * Stop terminal with ctrl+Z
 */
public class ProfanityFilter {
    private String swearWords;                                  // String input with sware words
    private String[] swearWordsArr;                             // Array of swear words
    private ArrayList<String[]> tweetArr = new ArrayList<>();   // Tweet with each line of words on each element
    private HashMap<String, String> swearMap;                   // HashMap of swearwords as key and filtered word as value


    static Scanner in = new Scanner(System.in);

    public ProfanityFilter(){
        swearWords = in.nextLine();
        while (in.hasNextLine()) {
            tweetArr.add(in.nextLine().split(" "));
        }
        swearWordsArr = swearWords.split(" ");
        swearMap = new HashMap<>();
        // Assign the swear words to the filtered words in the HashMap:
        for (String word : swearWordsArr) {
            String filterWord = "";
            word = word.toLowerCase();
            filterWord = filterWord(word);
            swearMap.put(word, filterWord);
        }
        in.close();
    }

    /**
     * Filter a swear word
     * @param word swear word to be filtered
     * @return the filtered word here with the format: "*&#$%"
     */
    public String filterWord(String word) {
        String filterWord = "";
        String[] filter = "*&#$%".split("");
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            filterWord += filter[counter];
            counter++;
            if (counter == filter.length) {
                counter = 0;
            }
        }
        return filterWord;
    }
    
    /**
     * ** This method should maybe be refactored **
     * print the tweet with the filtered swear words
     */
    public void display(){
        String[] punctArr = ",.!?".split("");
        List<String> punctMarks = Arrays.asList(punctArr);
          
        for (int i = 0; i < tweetArr.size(); i++) {     // For each line in the tweet
            String outputStr = "";
            ArrayList<String> arrLine = new ArrayList<>();
            for (String word : tweetArr.get(i)) {   // for each word in each line
                // if empty
                if (word.length()<1) {
                    arrLine.add(word);
                }
                // if word ends on a punctuation mark
                else if (punctMarks.contains(word.substring(word.length()-1))) {
                    String suffix = word.substring(word.length()-1);
                    String stem = word.substring(0, word.length()-1);
                    // if the word without punctuation is in the swear map
                    if (swearMap.containsKey(stem.toLowerCase())) {
                        word = swearMap.get(stem.toLowerCase());    // replace the word with the filtered word
                        word += suffix;
                        arrLine.add(word);
                    }
                    // otherwise just add the word with no formatting
                    else {
                        arrLine.add(word);
                    }
                }
                
                // if word is in swear map, replace with the filtered word
                else if (swearMap.containsKey(word.toLowerCase())) {
                    word = swearMap.get(word.toLowerCase());
                    arrLine.add(word);
                }
                // otherwise word is not a swear word
                else {
                    arrLine.add(word);
                }
            }
            // Print each line
            System.out.println(outputStr.join(" ", arrLine));
        }
    }

    /**
     * ** not used for the assignment **
     * Prints each value of the swear word hash map
     */
    public void displaySwear(){
        for (String word : swearMap.values()) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        ProfanityFilter p = new ProfanityFilter();
        p.display();
        /*
        i'm making some comments here
        */
    }
}
