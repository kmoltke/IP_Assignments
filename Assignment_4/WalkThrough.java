import java.util.Scanner;

/**
 * Alternative solution
 * @Author Teaching Assistants
 */
public class WalkThrough {
    // First line:
    // 5N-2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int width = 5 * N - 2;
        int sides =  N - 1;
        // sides * 2 < width
        for (int row = 0; (sides + 1) * 2 < width; row++) {
            sides =  Math.abs(N - 1 - row); // always positive numbers
            int full = N + 2 * row;
            int middle = N - 2 * row;

            for (int i = 0; i < sides; i++) System.out.print("♡");     // print UDEN println
            if (middle > 0) {
                for (int i = 0; i < full; i++) System.out.print("♥");     // print UDEN println
                for (int i = 0; i < middle; i++) System.out.print("♡");     // print UDEN println
                for (int i = 0; i < full; i++) System.out.print("♥");     // print UDEN println
            } else {
                for (int i = 0; i < width - 2 * sides; i++) System.out.print("♥");     // print UDEN println   
            }
            for (int i = 0; i < sides; i++) System.out.print("♡");     // print UDEN println

            System.out.println();                                       // Print new line

        }
    }
}
