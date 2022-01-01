import java.util.Scanner;
import java.util.regex.*;
public class PepTalk {

    
    /**
     * ASSIGNMENT 9
     * @author Kristian Moltke Reitzel
     * @param s String to encode peptalk
     * Prints to std output
     * 
You have decided to learn a new language because you are bored. You recently heard someone talk about "Peptalk", and you think that sounds interesting and useful. You decide to create a program that can help you learn the language by translating natural language to "Peptalk".

Definition of "Peptalk":

Every syllable of the word is repeated, such that the repetion starts with a "p"
In the repetition of the syllable, all leading consonants (if any) are replaced by a "p", i.e. cof-fe-e becomes cofpof-fepe-epe
A syllable is defined as: zero or more consonants followed by a single vowel followed by zero or more consonants. For this assignment, only {aeiou} are considered vowels.
For this assignment, we will use the following simplified rule for determining where to split a word into syllables: A word is subdivided into syllables in such a way that there is an even split of consonants between adjacent syllables. In case of an odd number of consonants between vowels, the latter syllable gets an extra consonant. Example, which also highlights the imperfection of the rule:
assignment
(a)ss(i)gnm(e)nt
(a)s-s(i)g-nm(e)nt
as-sig-nment
as-pas-sig-pig-nment-pent
aspassigpignmentpent
For this assignment you must have a main method that reads the input from stdin and outputs to stdout. The input will be sequence of words.

Create a class called PepTalk. This class should be able to encode "peptalk".
     */
    public static void findSyll(String s) {
        Pattern sylablePattern = Pattern.compile("([a-z&&[^aeiou]]*)([aeiou])(?=([a-z&&[^aeiou]]*)([aeiou]*))", Pattern.CASE_INSENSITIVE);
        Pattern vowel = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
        Matcher m = sylablePattern.matcher(s);
        String output = "";
            
        boolean beginningOfWord = true;
        boolean endOfWord = false;
        while (m.find()) {
            String sylable = "";
            int grp1Len = m.group(1).length();
            int grp3Len = m.group(3).length();
            
            // words with one vowel:
            if (beginningOfWord && m.group(4).isEmpty()) {
                sylable = m.group(1) + m.group(2) + m.group(3);
                endOfWord = true;
            }

            // if @ word beginning
            else if (beginningOfWord) {
                sylable = m.group(1);
                sylable += m.group(2);
                sylable += m.group(3).substring(0,grp3Len/2);
                beginningOfWord = false;
                endOfWord = false;
            }

            // if @ word end
            else if (m.group(4).isEmpty()) {
                sylable = m.group(1).substring(grp1Len/2);
                sylable += m.group(2);
                sylable += m.group(3);
                beginningOfWord = true;
                endOfWord = true;
            }
            else {
                sylable = m.group(1).substring(grp1Len/2);
                sylable += m.group(2);
                sylable += m.group(3).substring(0,grp3Len/2);
                beginningOfWord = false;
                endOfWord = false;
                
            }

            // repeat sylable with p in front if vowel
            if (vowel.matcher(sylable.substring(0,1)).matches()) {
                sylable += "p" + sylable.toLowerCase();
                if (endOfWord) sylable += " ";
            }
            // repeat sylable with p instead of first leading consonants
            else {
                sylable += sylable.replaceFirst("[a-zA-Z&&[^aeiouAEIOU]]*", "p");
                if (endOfWord) sylable += " ";
            }
            output += sylable;
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        PepTalk.findSyll(s);
    }
}

