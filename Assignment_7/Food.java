/**
 * @author Kristian Moltke Reitzel
 */
public class Food {
    protected String name;
    protected int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void display(){
        System.out.print(price + " kr " + name);    // NOT printLINE
    }
}
