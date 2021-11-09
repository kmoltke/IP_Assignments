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

    public void depositMoney(int dkk) throws NegativeAmountException {
        if (dkk < 0) throw new NegativeAmountException();
        else {
            balance += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + balance);
        }
    }

    public boolean isCheckedIn(int timeStamp) {
        System.out.println(timeTraveled(timeStamp) + " minutes passed since last check in");
        return isCheckedIn && timeTraveled(timeStamp) < 120 ? true : false;
    }

    public int timeTraveled(int timeStamp) {
        return timeStamp - this.timeStamp;
    }

    public void checkIn(int x, int y, int timeStamp) {
        xCoords.add(x);
        yCoords.add(y);

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
            
        }

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
    
}