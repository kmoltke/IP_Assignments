import java.util.*;

/**
 * @author Kristian Moltke Reitzel
 */
public class Main {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var N = in.nextInt();

        int lineLength = (N*3) + (N-1)*2;   // Number of hearts in one line
        int bottomLines;                    // Number of lines below middle line
        /**
         * Section of hearts above middle line
         */
        int sec1 = N - 1;                   // First and last section of unfilled hearts
        int sec2 = N;                       // Section of filled hearts
        int sec3 = N;                       // Middle section of unfilled hearts
        /**
         * Section of hearts below middle line
         */
        int sec4 = 1;                       // Section of unfilled hearts
        int sec5 = lineLength - 2;          // Middle section of filled hearts
    
        /**
         * Set bottomLines depending on N%2 == 0
         */
        // Even N
        if (N%2 == 0) {
          bottomLines = (lineLength/2)-1;
        }
        // Uneven N
        else {
            bottomLines = lineLength / 2;
        }

        /**
         * The code
         */

        for (int line = 0; line < bottomLines + N; line++) {
            String buildLn = "";                        // Builds eatch line of hearts
            /**
             * Top part:
             */
            if (line < N) {
                buildLn += "♡".repeat(sec1);
                buildLn += "♥".repeat(sec2);
                if (sec3 == 0){                         // When no hearts in middle section
                    if (N%2 == 0) {                     // And if N is even - only print one heart
                        buildLn += "♥";
                    }
                    sec2 --;
                }
                else {
                    buildLn += "♡".repeat(sec3);
                }
                
                buildLn += "♥".repeat(sec2);
                buildLn += "♡".repeat(sec1);
                sec1 --;
                sec2 += 2;
                if (sec3 <= 1) {
                    sec3 = 0;
                }
                else {
                    sec3 -= 2;
                }
            }

            /**
             * Middle line:
             */
            else if (N != 1 && line == N-1) {
                buildLn = "♥".repeat(lineLength);
            }
            
            
            /**
             * Bottom part:
             */
            else {
                buildLn += "♡".repeat(sec4);
                buildLn += "♥".repeat(sec5);
                buildLn += "♡".repeat(sec4);
                sec4 ++;
                sec5 -= 2;
            }
            System.out.println(buildLn);                // Print buildLn for eatch line
        }   
    }
}