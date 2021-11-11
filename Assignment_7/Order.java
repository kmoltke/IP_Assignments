import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristian Moltke Reitzel
 */
public class Order {
    protected List<Food> ordered;

    public Order() {
        this.ordered = new ArrayList<>();
    }

    public void addFood(Food food) {
        ordered.add(food);
    }

    public int total() {
        int total = 0;
        for (Food food : ordered) {
            total += food.getPrice();
        }

        return total;
    }

    public void display() {

        for (Food food : ordered) {
            food.display();
            System.out.println();
        }

        System.out.println(total() + " kr TOTAL");
    }

    public boolean payWith(CreditCard card) {
        if (card.withdraw(total()) == false) {
            System.out.println("ERROR: Payment failed");
            return false;
        }
        else {
            return true;
        }
    }

    /*
    public static void main(String[] args) {
        Pizza p1 = new Pizza();
        Food b1 = new Food("Burger", 65);
        Food s1 = new Food("Salad", 30);
        p1.addTopping("Pepperoni");
        p1.addTopping("Onions");
        Order order1 = new Order();
        order1.addFood(p1);
        order1.addFood(b1);
        order1.addFood(s1);

        // p1.display();
        order1.display();
    }
    */
}
