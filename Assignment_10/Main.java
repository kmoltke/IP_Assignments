public class Main {
    public static void main(String[] args) throws NegativeAmountException {
        RejseKort rejsekort = new RejseKort();
        rejsekort.depositMoney(100);
        rejsekort.depositMoney(-50);

    }
}
