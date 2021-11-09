public class Main {
    public static void main(String[] args) throws NegativeAmountException {
        RejseKort r = new RejseKort();
        // r.depositMoney(100);
        r.checkIn(0, 0, 5);
        System.out.println(r.isCheckedIn(8));
    }
}
