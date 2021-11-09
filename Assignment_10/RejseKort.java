import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kristian Moltke Reitzel
 * 
 * RejseKort
 * 
 */
public class RejseKort {
    private int balance;
    private boolean isCheckedIn;
    private int timeStamp;
    private Set<Integer> xCoords;
    private Set<Integer> yCoords;

    public RejseKort() {
        balance = 100;
        isCheckedIn = false;
        xCoords = new HashSet<>();
        yCoords = new HashSet<>();
    }

    public void depositMoney(int dkk) {
        try {
            if (dkk < 0) throw new NegativeAmountException();
            balance += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + balance + " DKK");
            
        } catch (NegativeAmountException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean isCheckedIn(int timeStamp) {
        // System.out.println(timeTraveled(timeStamp) + " minutes passed since last check in");
        return isCheckedIn && timeTraveled(timeStamp) < 120 ? true : false;
    }

    public int timeTraveled(int timeStamp) {
        return timeStamp - this.timeStamp;
    }

    public void checkIn(int x, int y, int timeStamp) throws NotEnoughMoneyException {
        addCoordinates(x, y);
        if (balance < 100) {
            throw new NotEnoughMoneyException(balance);
        }

        if (isCheckedIn) {
            System.out.println("Continued journey (" + timeTraveled(timeStamp) + " minutes since last check in)");
        } 
        else {
            isCheckedIn = true;
            this.timeStamp = timeStamp;
            System.out.println("Checked in");
        }
    }

    public void checkOut(int x, int y, int timeStamp) throws NotCheckedInException {
        if (!isCheckedIn) {
            throw new NotCheckedInException();
        }
        else {
            addCoordinates(x, y);
            balance = balance - calculatePrice();
            isCheckedIn = false;
            System.out.println("Checked out! " + timeTraveled(timeStamp) + " minutes since last check in. Price is " + calculatePrice() + " DKK, remaining balance is " + balance + " DKK");
        }

    }

    public void addCoordinates(int x, int y) {
        xCoords.add(x);
        yCoords.add(y);
    }

    public int calculatePrice() {
        int maxX = Collections.max(xCoords);
        int maxY = Collections.max(yCoords);
        int minX = Collections.min(xCoords);
        int minY = Collections.min(yCoords);
        int result = 12 + (maxX - minX + maxY - minY) * 3;
        if (result<12) {
            return 12;
        }
        return result < 50 ? result : 50;
    }

    public int getBalance() {
        return balance;
    }
    
}