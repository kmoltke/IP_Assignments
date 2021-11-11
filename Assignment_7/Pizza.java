import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristian Moltke Reitzel
 */
public class Pizza extends Food {
    protected List<String> toppings;   // List of toppings

    public Pizza(){
        super("Pizza", 45);
        this.toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        toppings.add(topping);
        price += 10;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String toppingStr = " { ";
        toppingStr += String.join(", ", toppings);
        toppingStr += " }";
        
        return toppingStr;
    }

    @Override
    public void display(){
        super.display();
        System.out.print(toString());
    }
}
