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



    public RejseKort() {
        balance = 100;
        isCheckedIn = false;
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
        this.timeStamp = timeStamp;
    }

    public void checkOut(int x, int y, int timeStamp) {

    }
    
}