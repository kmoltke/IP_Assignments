public class NegativeAmountException extends Exception {
    private String message;
    public NegativeAmountException() {
        message = "Error: Cannot deposit negative amount";
        // System.out.println("Error: Cannot deposit negative amount");
    }
    public String getMessage() {
        return message;
    }
}
