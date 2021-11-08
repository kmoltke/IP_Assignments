/**
 * @author Kristian Moltke Reitzel
 */
public class Main {
    public static void main(String[] args) {
        Tree tree2 = new Tree(25);
        System.out.println(tree2.toString());
        tree2.growOneYear();
        for (int i = 0; i < 24; i++) {
            tree2.growOneYear();
            System.out.println(tree2.toString());
        }
    
        Forest forest1 = new Forest();
        forest1.addTree(25);
        forest1.addTree(25);
        forest1.addTree(25);
        forest1.addTree(25);
        forest1.addTree(25);
        System.out.println(forest1.toString());
        forest1.growOneYear();
        System.out.println(forest1.toString());
    }
}
