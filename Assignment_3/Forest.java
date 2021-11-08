import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.util.*;

/**
 * @author Kristian Moltke Reitzel
 */
public class Forest {
    private ArrayList<Tree> trees;

    public Forest(){
        trees = new ArrayList<>();
    }

    /**
     * 
     * @param growthPct
     */
    public void addTree(int growthPct){
        // var forestSize = 0;
        // forestSize ++;
        Tree tree = new Tree(growthPct);
        trees.add(tree);
    }

    public void addTree(double growthPct, String name){
        trees.add(new Tree(growthPct, name));
    }

    public String toString(){
        String buildString;
        buildString = "Forest(";
        for (int i = 0; i < trees.size(); i++) {
            buildString += "Tree(age = " + trees.get(i).getAge() + ", height = " + trees.get(i).getHeight() + ")";
        }
        return buildString + ")";
    }

    public List<Tree> getTrees(){
        return this.trees;
    }

    /*  MERE ELEGANG LØSNING (måske?):
    public String toString() {
        String buildString = "Forest(";
        for (Tree tree : trees) {
            buildString += tree.toString();
        }
        return buildString + ")";
    }
    */

    public void growOneYear(){
        for (int i = 0; i < trees.size(); i++) {
            trees.get(i).growOneYear();
        }
    }

    /*  SAMME:
    public void growOneYear(){
        for (Tree tree : trees) [
            tree.growOneYear();
        ]
    }
    */


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 
        System.out.println("Please, insert a comma separated list of trees:");
        String inputTrees = input.nextLine();
        System.out.println(inputTrees);

        String[] treeArray = inputTrees.split(",");
        for (String s : treeArray){
            System.out.println(s);
        }

        List<String> treeList = new ArrayList<>();
        for (String s : treeArray) {
            treeList.add(s.trim());
        }

        Set<String> treeSet = new HashSet<>();
        treeSet.addAll(treeList);

        Iterator<String> treeIterator = treeSet.iterator();
        Map<String, Double> treeMap = new HashMap<>();

        while (treeIterator.hasNext()) {
            String tree = treeIterator.next();
            System.out.println("Growth pct. for tree " + tree + ": ");
            while (!input.hasNextDouble()) {
                System.out.println("Only double values allowed");
                input.next();
            }
            double growthPct = input.nextDouble();
            treeMap.put(tree, growthPct);
        }

        Forest forest = new Forest();
        for (Map.Entry<String, Double> tree : treeMap.entrySet()){
            forest.addTree(tree.getValue(), tree.getKey());

        }
    }
}
