import java.util.Scanner;

/**
 * Song
 * Fiddled around with the recursive method call because of the Scanner
 * needed to be declared staticly (for some reason?)
 * @author Kristian Moltke Reitzel
 */
public class Song {
    int N;              // number of drinks
    String container;   // type of container
    String drink;       // type of drink
    static Scanner in = new Scanner(System.in);
    
    
    public Song(){
        N = in.nextInt();
        container = in.next();
        container = container.substring(0, container.length()-1);   // container -s
        String deleteOf = in.next();    // .skip("of") doesn't work for some reason
        drink = in.next();
        in.close();
    }
    
    /**
     * Print song
     */
    public void printSong(){
        switch (N) {
            case 1:
                System.out.println("One " + container + " of " + drink + " on the wall");
                System.out.println("One " + container + " of " + drink);
                System.out.println("Take one down, pass it around");
                System.out.println("No more " + container + "s of " + drink + " on the wall");
                return;
            case 2:
                System.out.println(N + " " + container + "s of " + drink + " on the wall");
                System.out.println(N + " " + container + "s of " + drink);
                System.out.println("Take one down, pass it around");
                System.out.println("One " + container + " of " + drink + " on the wall");
                System.out.println();
                break;
            default:
                System.out.println(N + " " + container + "s of " + drink + " on the wall");
                System.out.println(N + " " + container + "s of " + drink);
                System.out.println("Take one down, pass it around");
                System.out.println(N - 1 + " " + container + "s of " + drink + " on the wall");
                System.out.println();
                break;
        }
        N --;
        printSong();
    }

    public static void main(String[] args) {
        Song song1 = new Song();
        song1.printSong();
    }
}