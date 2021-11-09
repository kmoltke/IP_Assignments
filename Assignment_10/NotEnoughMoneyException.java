public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(int balance) {
        int differance = 100 - balance;
        System.out.println("Not enough money in account to check in. Please deposit at least " + differance + " DKK");
    }
}
