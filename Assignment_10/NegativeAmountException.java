public class NegativeAmountException extends Exception {
    public NegativeAmountException() {
        System.out.println("Error: Cannot deposit negative amount");
    }
}
