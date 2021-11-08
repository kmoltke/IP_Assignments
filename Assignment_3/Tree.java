/**
 * Tree
 * @author Kristian Moltke Reitzel
 */
public class Tree {
    private int age;            //  Years
    private double height;      //  Meters
    private double growthPct;   //  Growth pct pr year
    private String name;        //  Tree's name

    // Default constructor
    public Tree(){

    }

    public Tree(double growthPct){
        height = 0.25;
        age = 1;
        this.growthPct = growthPct;
        this.name = "unknown";
    }

    public Tree(double growthPct, String name){
        height = 0.25;
        age = 1;
        this.growthPct = growthPct;
        this.name = name;
    }

    public String toString(){
        //return "Tree(name = " + name + ", age = " + age + ", height = " + height + ")";
        return String.format("Tree(name = %s, age = %d, height = %s", this.name, this.age, this.height);
    }

    public void growOneYear(){
        age ++;
        if (height * (1 + growthPct / 100)<20) {
            height = height * (1 + growthPct / 100);
        }
        else {
            height = 20;
        }
    }

    public int getAge(){
        return age;
    }

    public double getHeight(){
        return height;
    }

    public String getName(){
        return name;
    }
}