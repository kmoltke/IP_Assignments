/**
 * @author Kristian Moltke Reitzel
 * 
 * RejseKort
 * 
 */
public class RejseKort {
    private int balance;
    private boolean isCheckedIn;



    public RejseKort() {
        balance = 100;
        isCheckedIn = false;
    }

    public void depositMoney(int dkk) throws NegativeAmountException {
        if (dkk<0) throw new NegativeAmountException();
        else {
            balance += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + balance);
        }
    }

    public boolean isCheckedIn(int timeStamp) {
        return true;
    }

    public void checkIn(int x, int y, int timeStamp) {

    }

    public void checkOut(int x, int y, int timeStamp) {

    }
    
}